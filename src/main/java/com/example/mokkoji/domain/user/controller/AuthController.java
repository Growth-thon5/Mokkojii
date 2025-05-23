package com.example.mokkoji.domain.user.controller;

import com.example.mokkoji.domain.user.controller.dto.request.JoinRequest;
import com.example.mokkoji.domain.user.controller.dto.request.LoginRequest;
import com.example.mokkoji.domain.user.service.AuthService;
import com.example.mokkoji.domain.user.service.UserService;
import com.example.mokkoji.global.response.ApiResponse;
import com.example.mokkoji.security.jwt.service.JwtTokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final JwtTokenService jwtTokenService;
    private final AuthService authService;
    
    // 이메일 회원가입
    @PostMapping(value = "/join", produces = "application/json; charset=UTF-8")
    public ApiResponse<String> join(@Valid @RequestBody JoinRequest joinRequest) throws NoSuchAlgorithmException {
        userService.join(joinRequest);
        return ApiResponse.ok("회원가입이 완료되었습니다.");
    }

    // 이메일 로그인
    @PostMapping(value = "/login", produces = "application/json; charset=UTF-8")
    public ApiResponse<String> login(@RequestBody @Valid LoginRequest loginRequest, HttpServletResponse response) {
        // 사용자 정보 검증
        String accessToken = authService.authenticateUser(loginRequest.email(), loginRequest.password(), response);
        return ApiResponse.ok(accessToken);
    }

    // refresh 토큰으로 accessToken 재발급
    @PostMapping(value = "/refresh", produces = "application/json; charset=UTF-8")
    public ApiResponse<String> refresh(HttpServletRequest request) {
        String newAccessToken = jwtTokenService.reissueByRefreshToken(request);
        return ApiResponse.ok(newAccessToken);
    }

    // 로그아웃
    @PostMapping(value = "/logout", produces = "application/json; charset=UTF-8")
    public ApiResponse<String> logout(HttpServletRequest request, HttpServletResponse response) {
        jwtTokenService.deleteRefreshToken(request,response);
        return ApiResponse.ok("로그아웃 성공");
    }
}
