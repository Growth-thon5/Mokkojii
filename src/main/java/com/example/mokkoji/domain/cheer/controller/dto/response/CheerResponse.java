package com.example.mokkoji.domain.cheer.controller.dto.response;

import com.example.mokkoji.domain.cheer.entity.Cheer;
import com.example.mokkoji.domain.tag.entity.TagType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class CheerResponse {
    private Long cheerId;
    private String content;
    private String writerNickname;
    private int likeCount;
    private List<TagType> tagList;
    private LocalDateTime createdAt;
    private List<String> imageList;

    // 정적 팩토리 메서드 추가
    public static CheerResponse from(Cheer cheer) {
        return CheerResponse.builder()
                .cheerId(cheer.getId())
                .content(cheer.getContent())
                .writerNickname(cheer.getUser().getUsername())  // ✅ username으로 변경
                .likeCount(cheer.getLikeCount())
                .imageList(cheer.getImageList())
                .tagList(cheer.getCheerTagList())
                .createdAt(cheer.getCreatedAt())
                .build();
    }
}
