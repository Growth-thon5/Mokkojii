package com.example.mokkoji.domain.cheer.controller.dto.request;

import lombok.Getter;

@Getter
public class CheerCommentRequest {
    private Long userId;
    private String content;
}
