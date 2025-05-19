package com.example.mokkoji.domain.store.service;

import com.example.mokkoji.domain.store.controller.dto.request.AddStoreInfoRequest;
import com.example.mokkoji.domain.store.controller.dto.request.MenuRequest;
import com.example.mokkoji.domain.store.controller.dto.request.StoreRegisterRequest;
import com.example.mokkoji.domain.store.entity.Menu;
import com.example.mokkoji.domain.store.entity.Store;
import com.example.mokkoji.domain.store.repository.StoreRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreOwnerService {

    private final StoreRepository storeRepository;

    // 가게 등록
    public Store createStore(StoreRegisterRequest request) {
        Store newStore= Store.of(request);
        return storeRepository.save(newStore);
    }

    public void addStoreInfo(Long storeId,@Valid AddStoreInfoRequest request) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("Store not found"));
        store.addStoreInfo(request);
    }

    public void addMenu(Long storeId,MenuRequest request) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("Store not found"));
        store.addMenu(Menu.of(request));
    }
}
