package com.example.mokkoji.domain.tag.entity;

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
}
