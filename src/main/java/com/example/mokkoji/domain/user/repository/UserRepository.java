package com.example.mokkoji.domain.user.repository;

import com.example.mokkoji.domain.user.entity.OAuthProvider;
import com.example.mokkoji.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findBySocialAndSocialId(OAuthProvider social, String socialId);

}
