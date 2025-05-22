package com.example.mokkoji.domain.user.controller;

import com.example.mokkoji.domain.user.entity.User;
import com.example.mokkoji.domain.user.repository.UserRepository;
import com.example.mokkoji.global.response.ApiResponse;
import com.example.mokkoji.security.oauth2.kakao.aop.CurrentUserId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/me")
    public ApiResponse<User> getMyInfo(@CurrentUserId Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));
        return ApiResponse.ok(user);
    }
}
