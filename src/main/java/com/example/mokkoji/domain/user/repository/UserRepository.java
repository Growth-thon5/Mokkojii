package com.example.mokkoji.domain.user.repository;

import com.example.mokkoji.domain.user.entity.AuthProvider;
import com.example.mokkoji.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByProviderAndSocialId(AuthProvider provider, String socialId);

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
}
