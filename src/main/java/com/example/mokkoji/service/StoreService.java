package com.example.mokkoji.service;

import com.example.mokkoji.dto.StoreRequest;
import com.example.mokkoji.entity.Store;
import com.example.mokkoji.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class StoreService {

    private final StoreRepository storeRepository;

    public Store createStore(StoreRequest request) {
        Store store = Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .description(request.getDescription())
                .build();
        return storeRepository.save(store);
    }
}

