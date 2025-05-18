package com.example.mokkoji.security.jwt.domain;

import com.example.mokkoji.security.jwt.domain.JwtToken;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface JwtTokenRedisRepository extends CrudRepository<JwtToken, String> {

    Optional<JwtToken> findByRefreshToken(String refreshToken);

    void deleteByRefreshToken(String refreshToken);

}
