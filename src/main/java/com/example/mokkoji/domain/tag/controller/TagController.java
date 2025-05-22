package com.example.mokkoji.domain.tag.controller;

import com.example.mokkoji.domain.tag.entity.TagType;
import com.example.mokkoji.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tags")
public class TagController {

    // 전체 태그 설명(한글) 목록 반환
    @GetMapping
    public ApiResponse<List<String>> getAllTagDescriptions() {
        List<String> tags = Arrays.stream(TagType.values())
                .map(TagType::getDescription)
                .toList();

        return ApiResponse.ok(tags);
    }
}
