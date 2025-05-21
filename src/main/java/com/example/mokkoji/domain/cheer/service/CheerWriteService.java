package com.example.mokkoji.domain.cheer.service;

import com.example.mokkoji.domain.cheer.controller.dto.request.CheerRequest;
import com.example.mokkoji.domain.cheer.entity.Cheer;
import com.example.mokkoji.domain.cheer.repository.CheerRepository;
import com.example.mokkoji.domain.store.entity.Store;
import com.example.mokkoji.domain.store.repository.StoreRepository;
import com.example.mokkoji.domain.tag.entity.StoreTag;
import com.example.mokkoji.domain.tag.entity.TagType;
import com.example.mokkoji.domain.tag.repository.StoreTagRepository;
import com.example.mokkoji.domain.user.entity.User;
import com.example.mokkoji.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CheerWriteService {

    private final CheerRepository cheerRepository;
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;
    private final StoreTagRepository storeTagRepository;

    public void writeCheer(CheerRequest request, Long userId, Long storeId) {
        User owner = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 가게입니다."));

        List<TagType> tagTypes = request.tagList().stream()
                .map(tag -> TagType.fromDescription(String.valueOf(tag)))
                .collect(Collectors.toList());

        Cheer cheer = Cheer.builder()
                .content(request.content())
                .cheerTagList(tagTypes)
                .store(store)
                .imageList(request.imageList())
                .build();
        cheer.setUser(owner);

        cheerRepository.save(cheer);

        for (TagType tagType : tagTypes) {
            storeTagRepository.findByStoreAndTagType(store, tagType)
                    .ifPresentOrElse(
                            StoreTag::incrementCount,
                            () -> storeTagRepository.save(new StoreTag(store, tagType))
                    );
        }
    }

    public void updateCheer(Long messageId, String newContent) {
        Cheer cheer = cheerRepository.findById(messageId)
                .orElseThrow(() -> new IllegalArgumentException("응원글이 존재하지 않습니다."));
        cheer.updateContent(newContent);
    }

    public void deleteCheer(Long messageId) {
        Cheer cheer = cheerRepository.findById(messageId)
                .orElseThrow(() -> new IllegalArgumentException("응원글이 존재하지 않습니다."));
        cheerRepository.delete(cheer);
    }
}
