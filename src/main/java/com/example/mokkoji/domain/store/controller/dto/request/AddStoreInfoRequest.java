package com.example.mokkoji.domain.store.controller.dto.request;

public record AddStoreInfoRequest(
        String openingTime,
        String closingTime,
        String directions,
        String thumbnail

) {}
