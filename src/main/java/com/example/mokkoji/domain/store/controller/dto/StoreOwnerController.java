package com.example.mokkoji.domain.store.controller.dto;

import com.example.mokkoji.domain.store.controller.dto.request.AddStoreInfoRequest;
import com.example.mokkoji.domain.store.controller.dto.request.MenuListRequest;
import com.example.mokkoji.domain.store.controller.dto.request.MenuRequest;
import com.example.mokkoji.domain.store.controller.dto.request.StoreRegisterRequest;
import com.example.mokkoji.domain.store.entity.Store;
import com.example.mokkoji.domain.store.service.StoreOwnerService;
import com.example.mokkoji.global.response.ApiResponse;
import com.example.mokkoji.security.oauth2.kakao.aop.CurrentUserId;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/stores")
@RequiredArgsConstructor
public class StoreOwnerController {

    private final StoreOwnerService storeOwnerService;

    // 가게 등록 -> location도 같이 넘겨줘야함
    @PostMapping
    public ApiResponse<?> registerStore(@CurrentUserId Long userId, @Valid @RequestBody StoreRegisterRequest request) {
        Store created = storeOwnerService.createStore(request,userId);
        return ApiResponse.ok(created);
    }

    // 가게 정보 마저 등록
    @PostMapping("/{storeId}/info")
    public ApiResponse<?> addStoreInfo(@CurrentUserId Long userId,@PathVariable Long storeId,@Valid @RequestBody AddStoreInfoRequest request) {
        storeOwnerService.addStoreInfo(userId,storeId,request);
        return ApiResponse.ok("가게가 정보가 추가되었습니다.");
    }

    //  가게 상품 등록
    @PostMapping("/{storeId}/products")
    public ApiResponse<?> addMenu(@PathVariable Long storeId,@Valid @RequestBody MenuListRequest request) {
        List<MenuRequest> menus = request.menus();
        for (MenuRequest menu : menus) {

            storeOwnerService.addMenu(storeId,menu);
        }
        return ApiResponse.ok("메뉴가 생성되었습니다.");
    }

    // 관리자 승인

    // 가게 상세 정보 수정

    // 상품 상세 정보 수정 

    // 소상공인 확인서 인증
    
    // 내가 등록한 가게 목록 조회

    
}
