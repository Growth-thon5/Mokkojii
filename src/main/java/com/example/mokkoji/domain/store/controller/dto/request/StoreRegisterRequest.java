package com.example.mokkoji.domain.store.controller.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public record StoreRegisterRequest(
        @NotBlank(message = "가게명은 필수입니다.")
        String name,

        @NotBlank(message = "가게 소개는 필수입니다.")
        String description,

        @NotBlank(message = "주소는 필수입니다.")
        String address,

        @NotBlank(message = "가게 전화번호는 필수입니다.")
        @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "전화번호 형식이 올바르지 않습니다.")
        String phoneNumber,

        @NotBlank(message = "업종은 필수입니다.")
        String businessType,

        @NotNull(message = "개업일자는 필수입니다.")
        LocalDateTime openingDate,

        @NotBlank(message = "사업자 등록 번호는 필수입니다.")
        @Pattern(regexp = "^\\d{3}-\\d{2}-\\d{5}$", message = "사업자 등록 번호 형식이 올바르지 않습니다.")
        String businessNumber,

        @NotBlank(message = "소상공인 확인서 파일 경로는 필수입니다.")
        String certification
) {}
