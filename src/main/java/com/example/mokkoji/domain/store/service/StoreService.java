package com.example.mokkoji.domain.store.service;

import com.example.mokkoji.domain.store.entity.Store;
import com.example.mokkoji.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    // 모든 가게 목록 조회
//    public List<Store> findStoresWithin2Km(Double lat, Double lng) {
//        return storeRepository.findAll(lat, lng);
//    }

    // 특정 가게 조회
    public Store getStore(Long storeId) {
        return storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("Store not found with id: " + storeId));
    }

    // 키워드 기반 가게 검색
    public Page<Store> searchStores(String keyword, Pageable pageable) {
//        storeRepository.findByNameContainingIgnoreCase(keyword, pageable);
        return null;
    }


    public List<Store> findStoresByDong(String dong) {
        return storeRepository.findByAddressDong(dong);

    }

    public List<Store> searchStoresByName(String keyword) {
        return storeRepository.findByStoreName(keyword);
    }

}
