package com.example.mokkoji.security.oauth2.kakao;

import com.example.mokkoji.domain.user.controller.dto.UserLoginResponse;
import com.example.mokkoji.domain.user.entity.User;
import com.example.mokkoji.global.response.ApiResponse;
import com.example.mokkoji.security.jwt.service.JwtTokenService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final JwtTokenService tokenService;
    private final ObjectMapper objectMapper;

    /*
        기존에 존재하는 유저의 경우, 토큰 발급을 진행합니다.
     */

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        User user = principal.getUser();

        log.info("[onAuthenticationSuccess] user={}", user);

        String accessToken = tokenService.createAccessToken(authentication);

        tokenService.createRefreshToken(response, authentication);

        // ApiResponse에 담을 데이터 (Map 혹은 DTO)

        UserLoginResponse loginResponse = UserLoginResponse.from(user.getEmail(), accessToken);

        ApiResponse<UserLoginResponse> apiResponse = ApiResponse.ok(loginResponse);

        // 응답 설정
        response.setStatus(apiResponse.httpStatus().value());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Jackson으로 ApiResponse를 JSON으로 직렬화
        objectMapper.writeValue(response.getWriter(), apiResponse);
    }
}
