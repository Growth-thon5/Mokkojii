package com.example.mokkoji.domain.store.service;

import com.example.mokkoji.domain.store.entity.Store;
import com.example.mokkoji.domain.store.repository.StoreRepository;
import com.example.mokkoji.domain.tag.entity.TagType;
import com.example.mokkoji.domain.tag.repository.StoreTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ChartService {

    private final StoreTagRepository storeTagRepository;
    private final StoreRepository storeRepository;

    public List<Store> getHotplaceRanking() {
        return storeRepository.findByCheerCount();
    }

    public List<Store> getNewStores() {
        return storeRepository.findByCreatedAt();
    }

    public List<Store> getRankingByTag(TagType tag) {
        return storeTagRepository.findByTagCount(tag);

    }

}
