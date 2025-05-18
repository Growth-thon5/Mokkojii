package com.example.mokkoji.domain.user.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {
    PERSONAL("PERSONAL"),
    BUSINESS("BUSINESS"),
    ADMIN("ADMIN"),
    VISITOR("VISITOR");

    private final String role;

    Role(String role) {
        this.role = role;
    }

    @JsonValue
    public String getRole() {
        return role;
    }
}
