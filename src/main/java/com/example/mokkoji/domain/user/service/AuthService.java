package com.example.mokkoji.domain.user.service;

import com.example.mokkoji.domain.user.entity.User;
import com.example.mokkoji.domain.user.repository.UserRepository;
import com.example.mokkoji.global.response.CustomException;
import com.example.mokkoji.global.response.ErrorCode;
import com.example.mokkoji.security.jwt.service.JwtTokenService;
import com.example.mokkoji.security.jwt.util.PasswordUtil;
import com.example.mokkoji.security.oauth2.kakao.PrincipalDetails;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtTokenService jwtTokenService;

    // 이메일로 user확인, 현재 비밀번호 확인
    public String authenticateUser(String email, String password, HttpServletResponse response) {

        // 유저가 존재하는지 예외체크
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));


        if (!PasswordUtil.checkPassword(password, user.getPassword())) {
            throw new CustomException(ErrorCode.INVALID_CREDENTIALS);
        }


    // 유저 정보로 UserDetails 생성
        PrincipalDetails principalDetails = PrincipalDetails.of(user);

    // 수동으로 Authentication 객체 생성
        Authentication authentication =
                new UsernamePasswordAuthenticationToken(principalDetails, null, principalDetails.getAuthorities());

    // 이 Authentication 객체를 넘겨주면 OAuth와 동일한 방식으로 토큰 생성 가능
        String accessToken = jwtTokenService.createAccessToken(authentication);
        response.setHeader("Authorization", accessToken);
        jwtTokenService.createRefreshToken(response, authentication);

        return accessToken;
    }
}
