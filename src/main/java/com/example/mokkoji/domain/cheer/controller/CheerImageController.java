package com.example.mokkoji.domain.cheer.controller;

import com.example.mokkoji.domain.cheer.service.CheerImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/messages/images")
@RequiredArgsConstructor
public class CheerImageController {

    private final CheerImageService cheerImageService;

    @PostMapping
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile file) {
        try {
            String url = cheerImageService.saveImage(file);
            return ResponseEntity.ok(url);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("이미지 업로드 실패");
        }
    }
}


