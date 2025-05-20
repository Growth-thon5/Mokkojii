package com.example.mokkoji.domain.cheer.controller;

import com.example.mokkoji.domain.cheer.controller.dto.request.CheerCommentRequest;
import com.example.mokkoji.domain.cheer.controller.dto.request.CheerRequest;
import com.example.mokkoji.domain.cheer.controller.dto.response.CheerCommentResponse;
import com.example.mokkoji.domain.cheer.controller.dto.response.CheerResponse;
import com.example.mokkoji.domain.cheer.service.CheerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class CheerController {

    private final CheerService cheerService;

    // 응원글 작성
    @PostMapping
    public ResponseEntity<Void> writeCheer(@RequestBody CheerRequest request) {
        cheerService.writeCheer(request);
        return ResponseEntity.ok().build();
    }

    // 응원글 수정
    @PatchMapping("/{messageId}")
    public ResponseEntity<Void> updateCheer(@PathVariable Long messageId,
                                            @RequestBody Map<String, String> body) {
        cheerService.updateCheer(messageId, body.get("content"));
        return ResponseEntity.ok().build();
    }

    // 응원글 삭제
    @DeleteMapping("/{messageId}")
    public ResponseEntity<Void> deleteCheer(@PathVariable Long messageId) {
        cheerService.deleteCheer(messageId);
        return ResponseEntity.ok().build();
    }



    // 좋아요 기능
    @PostMapping("/{messageId}/like")
    public ResponseEntity<Void> likeCheer(@PathVariable Long messageId) {
        cheerService.likeCheer(messageId);
        return ResponseEntity.ok().build();
    }

    // 댓글 작성
    @PostMapping("/{messageId}/comments")
    public ResponseEntity<Void> addComment(@PathVariable Long messageId,
                                           @RequestBody CheerCommentRequest request) {
        cheerService.addComment(messageId, request);
        return ResponseEntity.ok().build();
    }

    // 댓글 목록 조회
    @GetMapping("/{messageId}/comments")
    public ResponseEntity<List<CheerCommentResponse>> getComments(@PathVariable Long messageId) {
        return ResponseEntity.ok(cheerService.getCommentList(messageId));
    }
    //태그 필터링
    //전체 피드 조회(인기순)
    @GetMapping("/feed")
    public ResponseEntity<List<CheerResponse>> getFeed(
            @RequestParam(defaultValue = "popular") String sortBy,  // 인기순이 기본
            @RequestParam(required = false) String tag
    ) {
        return ResponseEntity.ok(cheerService.getAllCheersFiltered(sortBy, tag));
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<CheerResponse>> getMyCheers(@PathVariable Long userId) {
        return ResponseEntity.ok(cheerService.getCheersByUser(userId));
    }
    //댓글 삭제 수정
    @PatchMapping("/comments/{commentId}/users/{userId}")
    public ResponseEntity<Void> updateComment(@PathVariable Long commentId,
                                              @PathVariable Long userId,
                                              @RequestBody Map<String, String> body) {
        cheerService.updateComment(commentId, userId, body.get("content"));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/comments/{commentId}/users/{userId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId,
                                              @PathVariable Long userId) {
        cheerService.deleteComment(commentId, userId);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/{messageId}/like/users/{userId}")
    public ResponseEntity<Void> likeCheer(@PathVariable Long messageId,
                                          @PathVariable Long userId) {
        cheerService.likeCheer(messageId, userId);
        return ResponseEntity.ok().build();
    }


}
