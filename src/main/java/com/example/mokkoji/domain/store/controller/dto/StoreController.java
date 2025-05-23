package com.example.mokkoji.domain.store.controller.dto;

import com.example.mokkoji.domain.store.controller.dto.response.LocationResponse;
import com.example.mokkoji.domain.store.controller.dto.response.StoreDetailResponse;
import com.example.mokkoji.domain.store.controller.dto.response.StoreListResponse;
import com.example.mokkoji.domain.store.entity.Location;
import com.example.mokkoji.domain.store.entity.Store;
import com.example.mokkoji.domain.store.service.StoreService;
import com.example.mokkoji.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("api/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    // 위치 정보 가져오기
    @GetMapping(value = "/location", produces = "application/json; charset=UTF-8")
    public ApiResponse<List<LocationResponse>> getAllLocations() {
        List<Location> result = storeService.getAllLocations();
        List<LocationResponse> locationList = LocationResponse.from(result);
        return ApiResponse.ok(locationList);
    }

    // 00동 검색하면 00동내에 있는 가게 목록
    @GetMapping(value = "/dong", produces = "application/json; charset=UTF-8")
    public ApiResponse<List<StoreListResponse>> getStoresByDong(@RequestParam String dong) {
        List<Store> result = storeService.findStoresByDong(dong);
        List<StoreListResponse> storeList = StoreListResponse.from(result);
        return ApiResponse.ok(storeList);
    }

    // 모든 가게 조회
    @GetMapping(produces = "application/json; charset=UTF-8")
    public ApiResponse<List<StoreListResponse>> getStores() {
        List<Store> result = storeService.findStoresList();
        List<StoreListResponse> storeList = StoreListResponse.from(result);
        return ApiResponse.ok(storeList);
    }

    // 가게 상세 조회
    @GetMapping(value = "/{storeId}", produces = "application/json; charset=UTF-8")
    public ApiResponse<StoreDetailResponse> getStore(@PathVariable Long storeId) {
        Store store = storeService.getStore(storeId);
        return ApiResponse.ok(StoreDetailResponse.from(store));
    }

    // 가게 이름으로 검색하면 -> 응원리스트 목록
    @GetMapping(value = "/search", produces = "application/json; charset=UTF-8")
    public ApiResponse<List<StoreListResponse>> searchStore(@RequestParam String keyword) {
        List<Store> result = storeService.searchStoresByName(keyword);
        List<StoreListResponse> storeList = StoreListResponse.from(result);
        return ApiResponse.ok(storeList);
    }

}
