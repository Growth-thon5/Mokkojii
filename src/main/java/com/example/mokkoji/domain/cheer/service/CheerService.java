package com.example.mokkoji.domain.cheer.service;

import com.example.mokkoji.domain.cheer.controller.dto.request.CheerCommentRequest;
import com.example.mokkoji.domain.cheer.controller.dto.request.CheerRequest;
import com.example.mokkoji.domain.cheer.controller.dto.response.CheerCommentResponse;
import com.example.mokkoji.domain.cheer.controller.dto.response.CheerResponse;
import com.example.mokkoji.domain.cheer.entity.Cheer;
import com.example.mokkoji.domain.cheer.entity.CheerComment;
import com.example.mokkoji.domain.cheer.repository.CheerCommentRepository;
import com.example.mokkoji.domain.cheer.repository.CheerLikeRepository;
import com.example.mokkoji.domain.cheer.repository.CheerRepository;
import com.example.mokkoji.domain.store.entity.Store;
import com.example.mokkoji.domain.store.repository.StoreRepository;
import com.example.mokkoji.domain.tag.entity.TagType;
import com.example.mokkoji.domain.user.entity.User;
import com.example.mokkoji.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.mokkoji.domain.cheer.entity.CheerLike;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CheerService {

    private final CheerRepository cheerRepository;
    private final CheerCommentRepository cheerCommentRepository;
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;

    // 응원글 작성
    public void writeCheer(CheerRequest request) {
        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));
        Store store = storeRepository.findById(request.storeId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 가게입니다."));

        // 한글 설명으로 TagType 찾기
        List<TagType> tagTypes = request.tagList().stream()
                .map(tag -> TagType.fromDescription(String.valueOf(tag)))
                .collect(Collectors.toList());


        Cheer cheer = Cheer.builder()
                .content(request.content())
                .cheerTagList(tagTypes)
                .user(user)
                .store(store)
                .build();

        cheerRepository.save(cheer);
    }

    // 응원글 수정
    public void updateCheer(Long messageId, String newContent) {
        Cheer cheer = cheerRepository.findById(messageId)
                .orElseThrow(() -> new IllegalArgumentException("응원글이 존재하지 않습니다."));

        cheer.updateContent(newContent);
    }

    // 응원글 삭제
    public void deleteCheer(Long messageId) {
        Cheer cheer = cheerRepository.findById(messageId)
                .orElseThrow(() -> new IllegalArgumentException("응원글이 존재하지 않습니다."));

        cheerRepository.delete(cheer);
    }

    // 전체 응원글 피드 정렬 조회
    public List<CheerResponse> getAllCheersSorted(String sortBy) {
        List<Cheer> cheers = cheerRepository.findAll();

        if (sortBy.equals("popular")) {
            cheers.sort((a, b) -> Integer.compare(b.getLikeCount(), a.getLikeCount()));
        } else {
            cheers.sort((a, b) -> b.getCreatedAt().compareTo(a.getCreatedAt()));
        }

        return cheers.stream()
                .map(CheerResponse::from)
                .toList();
    }

    // 좋아요
    public void likeCheer(Long messageId) {
        Cheer cheer = cheerRepository.findById(messageId)
                .orElseThrow(() -> new IllegalArgumentException("응원글이 존재하지 않습니다."));

        cheer.addLike();
    }

    // 댓글 작성
    public void addComment(Long messageId, CheerCommentRequest request) {
        Cheer cheer = cheerRepository.findById(messageId)
                .orElseThrow(() -> new IllegalArgumentException("응원글이 존재하지 않습니다."));

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));

        CheerComment comment = CheerComment.builder()
                .cheer(cheer)
                .user(user)
                .content(request.getContent())
                .build();

        cheerCommentRepository.save(comment);
        cheer.addCheerComment(comment);
    }

    // 댓글 목록 조회
    public List<CheerCommentResponse> getCommentList(Long messageId) {
        Cheer cheer = cheerRepository.findById(messageId)
                .orElseThrow(() -> new IllegalArgumentException("응원글이 존재하지 않습니다."));

        return cheer.getCheerCommentList().stream()
                .map(CheerCommentResponse::from)
                .toList();
    }
    //태그 필터링 기능
    public List<CheerResponse> getAllCheersFiltered(String sortBy, String tag) {
        List<Cheer> cheers;

        if (tag != null) {
            TagType tagType = TagType.valueOf(tag.toUpperCase());  // ex: "가성비굿" → GASEONBI_GOOD
            cheers = cheerRepository.findByCheerTagListContaining(tagType);
        } else {
            cheers = cheerRepository.findAll();
        }

        if (sortBy.equals("popular")) {
            cheers.sort((a, b) -> Integer.compare(b.getLikeCount(), a.getLikeCount()));
        } else {
            cheers.sort((a, b) -> b.getCreatedAt().compareTo(a.getCreatedAt()));
        }

        return cheers.stream()
                .map(CheerResponse::from)
                .toList();
    }
    //내 응원글 조회
    public List<CheerResponse> getCheersByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지 않습니다."));

        return cheerRepository.findByUser(user).stream()
                .map(CheerResponse::from)
                .toList();
    }
    //댓글 수정 & 삭제 기능
    @Transactional
    public void updateComment(Long commentId, Long userId, String newContent) {
        CheerComment comment = cheerCommentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("댓글이 존재하지 않습니다."));

        if (!comment.getUser().getId().equals(userId)) {
            throw new IllegalArgumentException("본인 댓글만 수정 가능합니다.");
        }

        comment.updateContent(newContent);
    }

    @Transactional
    public void deleteComment(Long commentId, Long userId) {
        CheerComment comment = cheerCommentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("댓글이 존재하지 않습니다."));

        if (!comment.getUser().getId().equals(userId)) {
            throw new IllegalArgumentException("본인 댓글만 삭제 가능합니다.");
        }

        cheerCommentRepository.delete(comment);
    }
    //좋아요 중복 방지
    @Autowired
    private CheerLikeRepository cheerLikeRepository;

    public void likeCheer(Long messageId, Long userId) {
        Cheer cheer = cheerRepository.findById(messageId)
                .orElseThrow(() -> new IllegalArgumentException("응원글이 존재하지 않습니다."));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지 않습니다."));

        // 이미 좋아요 한 경우 무시
        if (cheerLikeRepository.findByUserAndCheer(user, cheer).isPresent()) {
            return;
        }

        cheer.addLike();  // 좋아요 수 증가
        cheerLikeRepository.save(CheerLike.builder().user(user).cheer(cheer).build());
    }



}
