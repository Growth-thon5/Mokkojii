package com.example.mokkoji.domain.store.controller.dto.request;

import java.util.List;

public record MenuListRequest(
        List<MenuRequest> menus
) {
}
