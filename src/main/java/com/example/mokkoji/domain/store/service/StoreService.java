package com.example.mokkoji.domain.store.service;

import com.example.mokkoji.domain.store.entity.Location;
import com.example.mokkoji.domain.store.entity.Store;
import com.example.mokkoji.domain.store.repository.LocationRepository;
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
    private final LocationRepository locationRepository;

    // 위치정보 가져오기

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    // 모든 가게 목록 조회
     public List<Store> findStoresList() {
            return storeRepository.findAll();
        }

    // 특정 가게 조회
    public Store getStore(Long storeId) {
        return storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("Store not found with id: " + storeId));
    }

    // 키워드 기반 가게 검색
    public List<Store> searchStores(String keyword, Pageable pageable) {
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
