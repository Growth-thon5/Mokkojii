package com.example.mokkoji.domain.store.controller.dto.response;

import com.example.mokkoji.domain.store.entity.Store;

import java.util.List;

public record StoreListResponse(
        Long id,
        String name,
        String description,
        int cheerCount,
        String thumbnail,
        List<String> tags

) {
    public static List<StoreListResponse> from(List<Store> content) {
        return content.stream()
                .map(store -> new StoreListResponse(
                        store.getId(),
                        store.getName(),
                        store.getDescription(),
                        store.getCheerCount(),
                        store.getThumbnail(),
                        store.getStoreTagList().stream()
                                .map(storeTag -> storeTag.getTagType().getDescription()) // description은 "맛있어요", "핫플레이스" 같은 한글
                                .toList()
                ))
                .toList();
    }
}
