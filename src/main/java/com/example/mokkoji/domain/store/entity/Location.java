package com.example.mokkoji.domain.store.entity;

import com.example.mokkoji.domain.store.controller.dto.request.AddStoreInfoRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double latitude;
    private double longitude;
    private String addressDong;

    @OneToOne(mappedBy = "location")
    private Store store;

    public static Location of(AddStoreInfoRequest request) {
        return Location.builder()
                .latitude(request.latitude())
                .longitude(request.longitude())
                .addressDong(request.dong())
                .build();
    }
}
