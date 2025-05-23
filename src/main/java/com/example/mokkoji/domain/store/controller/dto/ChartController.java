package com.example.mokkoji.domain.store.controller.dto;

import com.example.mokkoji.domain.store.controller.dto.response.StoreListResponse;
import com.example.mokkoji.domain.store.entity.Store;
import com.example.mokkoji.domain.store.service.ChartService;
import com.example.mokkoji.domain.tag.entity.TagType;
import com.example.mokkoji.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("api/charts")
@RequiredArgsConstructor
public class ChartController {

    private final ChartService chartService;

    // 핫플 랭킹(응원수)
    @GetMapping(value = "/hotplaces", produces = "application/json; charset=UTF-8")
    public ApiResponse<List<StoreListResponse>> getHotplaceRanking() {
        List<Store> result = chartService.getHotplaceRanking();
        List<StoreListResponse> response = StoreListResponse.from(result);
        return ApiResponse.ok(response);
    }

    @GetMapping(value = "/new", produces = "application/json; charset=UTF-8")
    public ApiResponse<List<StoreListResponse>> getNewStores() {
        List<Store> result = chartService.getNewStores();
        List<StoreListResponse> response = StoreListResponse.from(result);
        return ApiResponse.ok(response);
    }

    // 태그별 응원 랭킹 -> RequestParam으로 받기
    @GetMapping(produces = "application/json; charset=UTF-8")
    public ApiResponse<List<StoreListResponse>> getHotplaceByTag(@RequestParam String tag) {
        TagType tagType = TagType.fromDescription(tag);
        List<Store> result = chartService.getRankingByTag(tagType);
        List<StoreListResponse> response = StoreListResponse.from(result);
        return ApiResponse.ok(response);
    }
}
