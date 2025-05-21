package com.example.mokkoji.domain.cheer.repository;

import com.example.mokkoji.domain.cheer.entity.Cheer;
import com.example.mokkoji.domain.cheer.entity.CheerLike;
import com.example.mokkoji.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CheerLikeRepository extends JpaRepository<CheerLike, Long> {
    Optional<CheerLike> findByUserAndCheer(User user, Cheer cheer);
}
