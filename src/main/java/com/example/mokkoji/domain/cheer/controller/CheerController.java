package com.example.mokkoji.domain.cheer.controller;

import com.example.mokkoji.domain.cheer.controller.dto.request.CheerCommentRequest;
import com.example.mokkoji.domain.cheer.controller.dto.request.CheerRequest;
import com.example.mokkoji.domain.cheer.controller.dto.response.CheerCommentResponse;
import com.example.mokkoji.domain.cheer.controller.dto.response.CheerResponse;
import com.example.mokkoji.domain.cheer.service.*;
import com.example.mokkoji.security.oauth2.kakao.aop.CurrentUserId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class CheerController {

    private final CheerCommentService cheerCommentService;
    private final CheerLikeService cheerLikeService;
    private final CheerQueryService cheerQueryService;
    private final CheerImageService cheerImageService;
    private final CheerWriteService cheerWriteService;

    // 응원글 작성
    @PostMapping("/{storeId}")
    public ResponseEntity<Void> writeCheer(@CurrentUserId Long userId,@PathVariable Long storeId,@RequestBody CheerRequest request) {
        cheerWriteService.writeCheer(request,userId,storeId);
        return ResponseEntity.ok().build();
    }

    // 응원글 수정
    @PatchMapping("/{messageId}")
    public ResponseEntity<Void> updateCheer(@PathVariable Long messageId,
                                            @RequestBody Map<String, String> body) {
        cheerWriteService.updateCheer(messageId, body.get("content"));
        return ResponseEntity.ok().build();
    }

    // 응원글 삭제
    @DeleteMapping("/{messageId}")
    public ResponseEntity<Void> deleteCheer(@PathVariable Long messageId) {
        cheerWriteService.deleteCheer(messageId);
        return ResponseEntity.ok().build();
    }


    // 좋아요 기능
    @PostMapping("/{messageId}/like")
    public ResponseEntity<Void> likeCheer(@PathVariable Long messageId,@CurrentUserId Long userId) {
        cheerLikeService.likeCheer(messageId,userId);
        return ResponseEntity.ok().build();
    }

    // 댓글 작성
    @PostMapping("/{messageId}/comments")
    public ResponseEntity<Void> addComment(@PathVariable Long messageId,
                                           @RequestBody CheerCommentRequest request,@CurrentUserId Long userId) {
        cheerCommentService.addComment(messageId, request,userId);
        return ResponseEntity.ok().build();
    }

    // 댓글 목록 조회
    @GetMapping(value = "/{messageId}/comments", produces = "application/json; charset=UTF-8")
    public ResponseEntity<List<CheerCommentResponse>> getComments(@PathVariable Long messageId) {
        return ResponseEntity.ok(cheerCommentService.getCommentList(messageId));
    }

    //댓글 수정
    @PatchMapping("/comments/{commentId}")
    public ResponseEntity<Void> updateComment(@PathVariable Long commentId,
                                              @RequestBody Map<String, String> body,@CurrentUserId Long userId) {
        cheerCommentService.updateComment(commentId, userId, body.get("content"));
        return ResponseEntity.ok().build();
    }

    //댓글 삭제
    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId,@CurrentUserId Long userId) {
        cheerCommentService.deleteComment(commentId, userId);
        return ResponseEntity.ok().build();
    }

    //태그 필터링
    //전체 피드 조회(인기순)
    @GetMapping(value = "/feed", produces = "application/json; charset=UTF-8")
    public ResponseEntity<List<CheerResponse>> getFeed(
            @RequestParam(defaultValue = "popular") String sortBy,  // 인기순이 기본
            @RequestParam(required = false) String tag
    ) {
        return ResponseEntity.ok(cheerQueryService.getAllCheersFiltered(sortBy, tag));
    }

    // 내 응원글 조회
    @GetMapping(value = "/users", produces = "application/json; charset=UTF-8")
    public ResponseEntity<List<CheerResponse>> getMyCheers(@CurrentUserId Long userId) {
        return ResponseEntity.ok(cheerQueryService.getCheersByUser(userId));
    }

//    @PostMapping("/{messageId}/like/users/{userId}")
//    public ResponseEntity<Void> likeCheer(@PathVariable Long messageId,
//                                          @PathVariable Long userId) {
//        cheerService.likeCheer(messageId, userId);
//        return ResponseEntity.ok().build();
//    }


}
