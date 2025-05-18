package com.example.mokkoji.domain.user.service;

import com.example.mokkoji.domain.user.controller.dto.request.JoinRequest;
import com.example.mokkoji.domain.user.entity.AuthProvider;
import com.example.mokkoji.domain.user.entity.Role;
import com.example.mokkoji.domain.user.entity.User;
import com.example.mokkoji.domain.user.repository.UserRepository;
import com.example.mokkoji.global.response.CustomException;
import com.example.mokkoji.global.response.ErrorCode;
import com.example.mokkoji.security.jwt.util.PasswordUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void join(JoinRequest joinRequest) throws NoSuchAlgorithmException {

        String encryptedPassword = PasswordUtil.encryptPassword(joinRequest.password());

        /// 이메일 중복 체크
        boolean emailUsed = isEmailUsed(joinRequest.email());

        if (emailUsed) {
            throw new CustomException(ErrorCode.DUPLICATE_EMAIL);
        }

        User joinUser = createUser(joinRequest, encryptedPassword);
        userRepository.save(joinUser);
    }

    // 존재하는 이메일 여부 확인
    private boolean isEmailUsed(String email) {
        return userRepository.existsByEmail(email);
    }

    // 유저 만들기
    private User createUser(JoinRequest joinRequest, String encryptedPassword) {
        return User.builder()
                .username("mokkoji")
                .email(joinRequest.email())
                .password(encryptedPassword)
                .role(Role.PERSONAL)
                .provider(AuthProvider.EMAIL)
                .socialId("null")
                .build();
    }
}
