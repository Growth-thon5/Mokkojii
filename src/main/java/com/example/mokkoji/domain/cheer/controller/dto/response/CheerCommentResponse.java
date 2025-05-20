package com.example.mokkoji.domain.cheer.controller.dto.response;

import com.example.mokkoji.domain.cheer.entity.CheerComment;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class CheerCommentResponse {
    private Long commentId;
    private String content;
    private String writerUsername;
    private LocalDateTime createdAt;

    public static CheerCommentResponse from(CheerComment comment) {
        return CheerCommentResponse.builder()
                .commentId(comment.getId())
                .content(comment.getContent())
                .writerUsername(comment.getUser().getUsername()) // User에 getUsername() 있음
                .createdAt(comment.getCreatedAt())
                .build();
    }
}
