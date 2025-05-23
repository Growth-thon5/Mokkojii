package com.example.mokkoji.domain.store.controller.dto;

import com.example.mokkoji.domain.store.entity.Store;
import com.example.mokkoji.domain.store.entity.StoreStatus;
import com.example.mokkoji.domain.store.repository.StoreRepository;
import com.example.mokkoji.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreAdminController {

    private final StoreRepository storeRepository;

    @PatchMapping("/{storeId}/approve")
    public ApiResponse<String> approveStore(@PathVariable Long storeId) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("가게가 존재하지 않습니다."));
        store.setStatus(StoreStatus.APPROVED);
        return ApiResponse.ok("가게 승인 완료");
    }
    @PatchMapping("/{storeId}/reject")
    public ApiResponse<String> rejectStore(@PathVariable Long storeId) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("가게가 존재하지 않습니다."));
        store.setStatus(StoreStatus.REJECTED);
        return ApiResponse.ok("가게 반려 완료");
    }
    @GetMapping("/pending")
    public ApiResponse<List<Store>> getPendingStores() {
        List<Store> pendingStores = storeRepository.findByStatus(StoreStatus.PENDING);
        return ApiResponse.ok(pendingStores);
    }


}
