package com.example.mokkoji.domain.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role; // PERSONAL, BUSINESS

    @Enumerated(EnumType.STRING)
    private AuthProvider provider; // KAKAO, EMAIL
    private String socialId;   // 해당 플랫폼의 고유 사용자 ID

    public void setRole(Role role) {
        this.role = role;
    }
}
