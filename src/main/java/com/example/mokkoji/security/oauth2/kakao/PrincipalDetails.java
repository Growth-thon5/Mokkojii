package com.example.mokkoji.security.oauth2.kakao;

import com.example.mokkoji.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Getter
@Builder
@RequiredArgsConstructor
public class PrincipalDetails implements UserDetails, OAuth2User {

    private final User user;
    private final Map<String, Object> attributes;

    // ✅ 이메일 로그인용 생성자
    public static PrincipalDetails of(User user) {
        return PrincipalDetails.builder()
                .user(user)
                .attributes(null)
                .build();
    }

    // ✅ 카카오 로그인용 생성자
    public static PrincipalDetails of(User user, Map<String, Object> attributes) {
        return PrincipalDetails.builder()
                .user(user)
                .attributes(attributes)
                .build();
    }

    // ✅ OAuth2User: OAuth2에서 제공하는 사용자 속성 반환
    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    // ✅ OAuth2User: 사용자 고유 식별자
    @Override
    public String getName() {
        return user.getEmail(); // 또는 user.getId().toString()
    }

    // ✅ UserDetails: 권한 반환
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(user.getRole().getRole()));
    }

    // ✅ 사용자 ID 반환
    public Long getId() {
        return user.getId();
    }

    // ✅ 도메인 User 객체 반환
    public User getUser() {
        return user;
    }

    // ✅ UserDetails: 사용자 비밀번호 반환
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    // ✅ UserDetails: 사용자 이름(이메일) 반환
    @Override
    public String getUsername() {
        return user.getEmail();
    }

    // ✅ 계정 만료 여부
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // ✅ 계정 잠김 여부
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // ✅ 자격 정보 만료 여부
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // ✅ 계정 활성화 여부
    @Override
    public boolean isEnabled() {
        return true;
    }
}
