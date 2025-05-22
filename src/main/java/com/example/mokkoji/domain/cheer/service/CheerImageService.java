package com.example.mokkoji.domain.cheer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheerImageService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    public String saveImage(MultipartFile file) throws IOException {
        // 1. Content-Type 검사
        String contentType = file.getContentType();
        if (contentType == null || !contentType.startsWith("image/")) {
            throw new IllegalArgumentException("이미지 파일만 업로드할 수 있습니다.");
        }

        // 2. 확장자 검사
        String originalFilename = file.getOriginalFilename();
        if (originalFilename != null && !originalFilename.matches(".*\\.(jpg|jpeg|png|gif|bmp)$")) {
            throw new IllegalArgumentException("지원하지 않는 이미지 확장자입니다.");
        }

        // 3. 파일 크기 제한 (5MB)
        if (file.getSize() > 5 * 1024 * 1024) {
            throw new IllegalArgumentException("이미지 크기는 5MB를 초과할 수 없습니다.");
        }

        // 4. 저장
        String filename = UUID.randomUUID() + "_" + originalFilename;
        Path fullPath = Paths.get(System.getProperty("user.dir"), uploadDir, filename);
        Files.createDirectories(fullPath.getParent());
        Files.write(fullPath, file.getBytes());

        return "/images/" + filename;
    }
}
