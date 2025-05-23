package com.example.mokkoji.domain.store.controller.dto;

import com.example.mokkoji.domain.store.controller.dto.response.StoreDetailResponse;
import com.example.mokkoji.domain.store.controller.dto.response.StoreListResponse;
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


    // 본인 위치에서 반경 2km내 가게 정렬 목록 (맨처음)
//    public ApiResponse<List<StoreListResponse>> getNearbyStores(@RequestParam double lat, @RequestParam double lng) {
//        List<Store> result = storeService.findStoresWithin2Km(lat, lng);
//        List<StoreListResponse> storeList = StoreListResponse.from(result);
//
//        return ApiResponse.ok(storeList);
//    }


    // 00동 검색하면 00동내에 있는 가게 목록
    @GetMapping("/dong")
    public ApiResponse<List<StoreListResponse>> getStoresByDong(@RequestParam String dong) {
        List<Store> result = storeService.findStoresByDong(dong);
        List<StoreListResponse> storeList = StoreListResponse.from(result);
        return ApiResponse.ok(storeList);
    }


    // 가게 상세 조회
    @GetMapping("/{storeId}")
    public ApiResponse<StoreDetailResponse> getStore(@PathVariable Long storeId) {
        Store store = storeService.getStore(storeId);
        return ApiResponse.ok(StoreDetailResponse.from(store));
    }

    // 가게 이름으로 검색하면 -> 응원리스트 목록
    @GetMapping("/search")
    public ApiResponse<List<StoreListResponse>> searchStore(@RequestParam String keyword) {
        List<Store> result = storeService.searchStoresByName(keyword);
        List<StoreListResponse> storeList = StoreListResponse.from(result);
        return ApiResponse.ok(storeList);
    }

}
