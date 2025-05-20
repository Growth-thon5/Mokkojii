package com.example.mokkoji.domain.cheer.repository;

import com.example.mokkoji.domain.cheer.entity.CheerComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheerCommentRepository extends JpaRepository<CheerComment, Long> {
}
