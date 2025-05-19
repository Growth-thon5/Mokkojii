package com.example.mokkoji.domain.user.controller.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record JoinRequest(
        @Email
        @NotBlank
        String email,

        @NotBlank
        String password

) {

}
