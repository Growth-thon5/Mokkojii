package com.example.mokkoji.domain.cheer.service;

import com.example.mokkoji.domain.cheer.controller.dto.response.CheerResponse;
import com.example.mokkoji.domain.cheer.entity.Cheer;
import com.example.mokkoji.domain.cheer.repository.CheerRepository;
import com.example.mokkoji.domain.tag.entity.TagType;
import com.example.mokkoji.domain.user.entity.User;
import com.example.mokkoji.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CheerQueryService {

    private final CheerRepository cheerRepository;
    private final UserRepository userRepository;

    public List<CheerResponse> getAllCheersSorted(String sortBy) {
        List<Cheer> cheers = cheerRepository.findAll();

        if ("popular".equals(sortBy)) {
            cheers.sort((a, b) -> Integer.compare(b.getLikeCount(), a.getLikeCount()));
        } else {
            cheers.sort((a, b) -> b.getCreatedAt().compareTo(a.getCreatedAt()));
        }

        return cheers.stream()
                .map(CheerResponse::from)
                .toList();
    }

    public List<CheerResponse> getAllCheersFiltered(String sortBy, String tag) {
        List<Cheer> cheers;

        if (tag != null) {
            TagType tagType = TagType.fromDescription(tag.toUpperCase());
            cheers = cheerRepository.findByCheerTagListContaining(tagType);
        } else {
            cheers = cheerRepository.findAll();
        }

        if ("popular".equals(sortBy)) {
            cheers.sort((a, b) -> Integer.compare(b.getLikeCount(), a.getLikeCount()));
        } else {
            cheers.sort((a, b) -> b.getCreatedAt().compareTo(a.getCreatedAt()));
        }

        return cheers.stream()
                .map(CheerResponse::from)
                .toList();
    }

    public List<CheerResponse> getCheersByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지 않습니다."));
        return cheerRepository.findByUser(user).stream()
                .map(CheerResponse::from)
                .toList();
    }
}
