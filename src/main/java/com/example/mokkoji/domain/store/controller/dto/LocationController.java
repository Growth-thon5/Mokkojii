package com.example.mokkoji.domain.store.controller.dto;

import com.example.mokkoji.domain.store.controller.dto.response.LocationResponse;
import com.example.mokkoji.domain.store.entity.Location;
import com.example.mokkoji.domain.store.service.StoreService;
import com.example.mokkoji.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("api/locations")
@RequiredArgsConstructor
public class LocationController {
    private final StoreService storeService;

    // 위치 정보 가져오기
    @GetMapping
    public ApiResponse<List<LocationResponse>> getAllLocations() {
        List<Location> result = storeService.getAllLocations();
        List<LocationResponse> locationList = LocationResponse.from(result);
        return ApiResponse.ok(locationList);
    }
}
