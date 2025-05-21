package com.example.mokkoji.domain.store.service;

import com.example.mokkoji.domain.store.controller.dto.request.AddStoreInfoRequest;
import com.example.mokkoji.domain.store.controller.dto.request.MenuRequest;
import com.example.mokkoji.domain.store.controller.dto.request.StoreRegisterRequest;
import com.example.mokkoji.domain.store.entity.Location;
import com.example.mokkoji.domain.store.entity.Menu;
import com.example.mokkoji.domain.store.entity.Store;
import com.example.mokkoji.domain.store.repository.LocationRepository;
import com.example.mokkoji.domain.store.repository.StoreRepository;
import com.example.mokkoji.domain.user.entity.User;
import com.example.mokkoji.domain.user.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.mokkoji.domain.user.entity.Role.BUSINESS;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreOwnerService {

    private final StoreRepository storeRepository;
    private final LocationRepository locationRepository;
    private final UserRepository userRepository;

    // 가게 등록
    public Store createStore(StoreRegisterRequest request,Long userId) {
        Store newStore= Store.of(request);
        User owner = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        newStore.setOwner(owner);
        owner.setRole(BUSINESS);

        return storeRepository.save(newStore);
    }

    public void addStoreInfo(Long userId,Long storeId,@Valid AddStoreInfoRequest request) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new RuntimeException("Store not found"));

        if (!store.getOwner().getId().equals(userId)) {
            throw new RuntimeException("You are not the owner of this store");
        }

        Location location=Location.of(request);
        locationRepository.save(location);
       
        store.addStoreInfo(request);
        store.setLocation(location);
    }

    public void addMenu(Long storeId,MenuRequest request) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("Store not found"));
        store.addMenu(Menu.of(request));
    }
}
