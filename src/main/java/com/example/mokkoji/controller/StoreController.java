package com.example.mokkoji.controller;

import com.example.mokkoji.dto.StoreRequest;
import com.example.mokkoji.entity.Store;
import com.example.mokkoji.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @PostMapping
    public ResponseEntity<?> createStore(@RequestBody StoreRequest request) {
        Store created = storeService.createStore(request);
        return ResponseEntity.ok(created);
    }
}
