package com.example.mokkoji.domain.store.controller.dto.response;

import com.example.mokkoji.domain.store.entity.Menu;
import lombok.Builder;

import java.util.List;

@Builder
public record MenuResponse(
        Long id,
        String menuName,
        String menuDescription,
        String imageUrl
) {
    public static List<MenuResponse> fromList(List<Menu> menuList) {
        return menuList.stream()
                .map(MenuResponse::from)
                .toList();
    }

    public static MenuResponse from(Menu menu) {
        return MenuResponse.builder()
                .id(menu.getId())
                .menuName(menu.getMenuName())
                .menuDescription(menu.getMenuDescription())
                .imageUrl(menu.getImageUrl())
                .build();
    }

}
