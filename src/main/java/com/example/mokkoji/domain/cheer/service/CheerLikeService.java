package com.example.mokkoji.domain.cheer.service;

import com.example.mokkoji.domain.cheer.entity.Cheer;
import com.example.mokkoji.domain.cheer.entity.CheerLike;
import com.example.mokkoji.domain.cheer.repository.CheerLikeRepository;
import com.example.mokkoji.domain.cheer.repository.CheerRepository;
import com.example.mokkoji.domain.user.entity.User;
import com.example.mokkoji.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CheerLikeService {

    private final CheerRepository cheerRepository;
    private final UserRepository userRepository;
    private final CheerLikeRepository cheerLikeRepository;

    public void likeCheer(Long messageId, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지 않습니다."));
        Cheer cheer = cheerRepository.findById(messageId)
                .orElseThrow(() -> new IllegalArgumentException("응원글이 존재하지 않습니다."));

        Optional<CheerLike> existingLike = cheerLikeRepository.findByUserAndCheer(user, cheer);
        if (existingLike.isPresent()) {
            cheerLikeRepository.delete(existingLike.get());
            cheer.decreaseLike();
        } else {
            cheerLikeRepository.save(new CheerLike(user, cheer));
            cheer.addLike();
        }
    }
}
