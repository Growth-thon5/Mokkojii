package com.example.mokkoji.domain.cheer.service;

import com.example.mokkoji.domain.cheer.controller.dto.request.CheerCommentRequest;
import com.example.mokkoji.domain.cheer.controller.dto.response.CheerCommentResponse;
import com.example.mokkoji.domain.cheer.entity.Cheer;
import com.example.mokkoji.domain.cheer.entity.CheerComment;
import com.example.mokkoji.domain.cheer.repository.CheerCommentRepository;
import com.example.mokkoji.domain.cheer.repository.CheerRepository;
import com.example.mokkoji.domain.user.entity.User;
import com.example.mokkoji.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CheerCommentService {

    private final CheerRepository cheerRepository;
    private final UserRepository userRepository;
    private final CheerCommentRepository cheerCommentRepository;

    public void addComment(Long messageId, CheerCommentRequest request,Long userId) {
        Cheer cheer = cheerRepository.findById(messageId)
                .orElseThrow(() -> new IllegalArgumentException("응원글이 존재하지 않습니다."));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));

        CheerComment comment = CheerComment.builder()
                .cheer(cheer)
                .user(user)
                .content(request.getContent())
                .build();

        cheerCommentRepository.save(comment);
        cheer.addCheerComment(comment);
    }

    public List<CheerCommentResponse> getCommentList(Long messageId) {
        Cheer cheer = cheerRepository.findById(messageId)
                .orElseThrow(() -> new IllegalArgumentException("응원글이 존재하지 않습니다."));

        return cheer.getCheerCommentList().stream()
                .map(CheerCommentResponse::from)
                .toList();
    }

    public void updateComment(Long commentId, Long userId, String newContent) {
        CheerComment comment = cheerCommentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("댓글이 존재하지 않습니다."));

        if (!comment.getUser().getId().equals(userId)) {
            throw new IllegalArgumentException("본인 댓글만 수정 가능합니다.");
        }

        comment.updateContent(newContent);
    }

    public void deleteComment(Long commentId, Long userId) {
        CheerComment comment = cheerCommentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("댓글이 존재하지 않습니다."));

        if (!comment.getUser().getId().equals(userId)) {
            throw new IllegalArgumentException("본인 댓글만 삭제 가능합니다.");
        }

        cheerCommentRepository.delete(comment);
    }
}
