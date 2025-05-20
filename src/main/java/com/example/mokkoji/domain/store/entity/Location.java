package com.example.mokkoji.domain.store.entity;

import jakarta.persistence.*;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double latitude;
    private double longitude;
    private String addressDong;

    @OneToOne(mappedBy = "location")
    private Store store;
}
