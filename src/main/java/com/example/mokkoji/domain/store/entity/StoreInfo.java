package com.example.mokkoji.domain.store.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.time.LocalDate;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreInfo {

    private String address;          // 주소
    private String directions;       // 오시는 길
    private String openingTime;     // 영업 시작 시간
    private String closingTime;     // 영업 종료 시간
    private String phoneNumber;      // 전화번호

    private String businessNumber;   // 사업자 등록 번호
    private LocalDate openingDate;   // 개업 일자

    private String certification; // 소상공인 확인서
}
