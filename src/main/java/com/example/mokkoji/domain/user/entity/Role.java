package com.example.mokkoji.domain.user.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public enum Role {
    PERSONAL,BUSINESS,ADMIN;
}
