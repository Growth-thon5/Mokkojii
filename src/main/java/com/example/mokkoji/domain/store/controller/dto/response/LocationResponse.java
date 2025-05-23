package com.example.mokkoji.domain.store.controller.dto.response;

import com.example.mokkoji.domain.store.entity.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class LocationResponse {
    private Long id;
    private String dongName;
    private Double latitude;
    private Double longitude;

    public static List<LocationResponse> from(List<Location> locationList) {
        return locationList.stream()
                .map(loc -> new LocationResponse(
                        loc.getId(),
                        loc.getAddressDong(),
                        loc.getLatitude(),
                        loc.getLongitude()
                ))
                .toList();
    }

}
