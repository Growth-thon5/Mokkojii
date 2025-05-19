package com.example.mokkoji.security.jwt.service;

import com.example.mokkoji.domain.user.repository.UserRepository;
import com.example.mokkoji.global.response.CustomException;
import com.example.mokkoji.global.response.ErrorCode;
import com.example.mokkoji.security.jwt.domain.JwtToken;
import com.example.mokkoji.security.jwt.domain.JwtTokenRedisRepository;
import com.example.mokkoji.security.jwt.util.JwtProvider;
import com.example.mokkoji.security.oauth2.kakao.PrincipalDetails;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.NoSuchElementException;
import java.util.Optional;

import static com.example.mokkoji.security.jwt.util.JwtProvider.REFRESH_TOKEN_EXPIRATION_TIME;


@Service
@Transactional
@RequiredArgsConstructor
public class JwtTokenService  {

    private final JwtProvider jwtProvider;
    // 유저 가져오기
    private final UserRepository userRepository;
    private final JwtTokenRedisRepository jwtTokenRedisRepository;

    // 액세스 토큰 생성하기
    public String createAccessToken(Authentication authentication) {
        return jwtProvider.generateAccessToken(authentication);
    }

    // 리프레쉬 토큰 생성하기
    public void createRefreshToken(HttpServletResponse response, Authentication authentication) {

        // 토큰을 발급한다.
        String refreshToken = jwtProvider.generateRefreshToken(authentication);

        // 만료 시간 설정
        LocalDateTime plusSeconds = LocalDateTime.now().plusSeconds(REFRESH_TOKEN_EXPIRATION_TIME);
        Long expiredAt = plusSeconds.atZone(ZoneId.systemDefault()).toEpochSecond();

        /// 인증 객체에서 정보 가져오기
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();

        // 해당 토큰을 레디스에 저장한다.
        JwtToken jwtToken = JwtToken.of(principalDetails.getId(), refreshToken, expiredAt);
        jwtTokenRedisRepository.save(jwtToken);

        // 토큰을 쿠키에 저장한다.
        setRefreshTokenInCookie(response, refreshToken);
    }

    // 재발급 하기
    public String reissueByRefreshToken(HttpServletRequest request) {

        // 1. 요청 헤더에서 Refresh Token 꺼내기
        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            throw new CustomException(ErrorCode.TOKEN_NOT_FOUND);
        }
        String refreshToken = header.substring(7);

        // 2. Redis에서 해당 refreshToken 존재 여부 확인
        JwtToken jwtToken = jwtTokenRedisRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new CustomException(ErrorCode.REFRESH_TOKEN_NOT_FOUND));

        // 3. 토큰 유효성 검사
        if (!jwtProvider.validateToken(refreshToken)) {
            // 유효하지 않은 토큰이면 삭제
            jwtTokenRedisRepository.deleteByRefreshToken(refreshToken);
            throw new CustomException(ErrorCode.INVALID_REFRESH_TOKEN);
        }

        // 4. 토큰이 유효하다면 Authentication 생성
        Authentication authentication = jwtProvider.getAuthentication(refreshToken);

        // 5. 새로운 Access Token 발급
        return jwtProvider.generateAccessToken(authentication);
    }

    public void deleteRefreshToken(HttpServletRequest request, HttpServletResponse response) {

        // 쿠키를 가져오기
        String refreshToken = getRefreshTokenFromCookie(request)
                .orElseThrow(() -> new SecurityException("쿠키에 RefreshToken 존재하지 않습니다."));
        System.out.println("쿠키에서 꺼낸 refreshToken = " + refreshToken);

        // 쿠키를 null 설정
        deleteRefreshTokenFromCookies(response);

        // DB에서도 삭제
        Optional<JwtToken> jwtTokenOpt = jwtTokenRedisRepository.findByRefreshToken(refreshToken);

        if(jwtTokenOpt.isPresent()) {
            System.out.println("토큰 발견: " + jwtTokenOpt.get());
            jwtTokenRedisRepository.delete(jwtTokenOpt.get());
            System.out.println("삭제 시도 완료");
        } else {
            System.out.println("토큰을 찾지 못했습니다.");
        }


    }

    /// 내부 함수
    // 쿠키에 리프레쉬 토큰을 저장
    private void setRefreshTokenInCookie(HttpServletResponse response, String refreshToken) {
        Cookie cookie = new Cookie("refreshToken", refreshToken);
        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        cookie.setPath("/");
        cookie.setMaxAge((int) REFRESH_TOKEN_EXPIRATION_TIME);
        response.addCookie(cookie);
    }


    // 쿠키에서 refreshToken 추출하는 메서드
    private Optional<String> getRefreshTokenFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("refreshToken".equals(cookie.getName())) {
                    return Optional.ofNullable(cookie.getValue());
                }
            }
        }
        return Optional.empty(); // Optional.empty() 반환
    }

    // 쿠키에서 리프레시 토큰 삭제
    private void deleteRefreshTokenFromCookies(HttpServletResponse response) {
        Cookie refreshTokenCookie = new Cookie("refreshToken", null);
        refreshTokenCookie.setMaxAge(0); // 쿠키 만료 시간을 0으로 설정하여 삭제
        refreshTokenCookie.setPath("/"); // 쿠키의 경로를 지정
        response.addCookie(refreshTokenCookie); // 응답에 추가하여 클라이언트에게 전송
    }
}
