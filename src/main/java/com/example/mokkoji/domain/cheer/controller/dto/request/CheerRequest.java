package com.example.mokkoji.domain.cheer.controller.dto.request;

import com.example.mokkoji.domain.tag.entity.TagType;

import java.util.List;

public record CheerRequest(
        Long storeId,
        String content,
        List<TagType> tagList,
        List<String> imageList
) {
}
