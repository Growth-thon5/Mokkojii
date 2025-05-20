package com.example.mokkoji.domain.cheer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;

@Service
@RequiredArgsConstructor
public class CheerImageService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    public String saveImage(MultipartFile file) throws IOException {
        String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path path = Paths.get(uploadDir + filename);
        Files.createDirectories(path.getParent());
        Files.write(path, file.getBytes());
        return "/images/" + filename;
    }
}
