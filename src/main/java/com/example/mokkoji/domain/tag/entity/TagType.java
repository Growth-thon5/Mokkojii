package com.example.mokkoji.domain.tag.entity;

import java.util.Arrays;

public enum TagType {

    TASTY("맛있어요"),
    KIND("친절해요"),
    GOOD_MOOD("분위기굿"),
    VALUE_FOR_MONEY("가성비짱"),
    QUALITY("품질인증");

    private final String description;

    TagType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    // 한글 설명으로 TagType 찾기
    public static TagType fromDescription(String description) {
        String cleaned = description.trim().replaceAll("^\"|\"$", ""); // 앞뒤 따옴표 제거
        return Arrays.stream(TagType.values())
                .filter(tagType -> tagType.description.equals(cleaned))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 태그입니다: " + description));
    }

}
