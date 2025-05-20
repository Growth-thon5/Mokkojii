package com.example.mokkoji.domain.store.controller.dto.response;

import com.example.mokkoji.domain.store.entity.Store;

import java.util.List;

public record StoreDetailResponse (
         Long id,
         String name,
         String description,
         String thumbnail,
         List<String> tags,
//         List<CheerMessageResponse> cheerMessages, // 응원 메시지
         String address, // ex: "서울 성동구 왕십리로 215-1 ...
         String directions,
         String phoneNumber,
         String closingTime,
         List<MenuResponse> menuList

) {
    public static StoreDetailResponse from(Store store) {
        return new StoreDetailResponse(
                store.getId(),
                store.getName(),
                store.getDescription(),
                store.getThumbnail(),
                // store.getStoreTagList()에서 TagType 리스트로 변환
                store.getStoreTagList().stream()
                        .map(storeTag -> storeTag.getTagType().name())
                        .toList(),

                store.getAddress() ,
                store.getDirections(),

                store.getPhoneNumber() ,
                store.getClosingTime(),
                store.getMenuList() != null ? MenuResponse.fromList(store.getMenuList()) : List.of()
        );
    }


}

