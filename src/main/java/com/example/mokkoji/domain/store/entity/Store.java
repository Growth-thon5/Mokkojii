// 4. Store Entity
package com.example.mokkoji.domain.store.entity;

import com.example.mokkoji.domain.cheer.entity.Cheer;
import com.example.mokkoji.domain.store.controller.dto.request.AddStoreInfoRequest;
import com.example.mokkoji.domain.store.controller.dto.request.StoreRegisterRequest;
import com.example.mokkoji.domain.tag.entity.StoreTag;
import com.example.mokkoji.domain.tag.entity.TagType;
import com.example.mokkoji.domain.user.entity.User;
import com.example.mokkoji.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "store")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Store extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // 가게명
    private String description; // 가게 설명
    private int cheerCount = 0; // 응원 수
    private String thumbnail; // 대표 이미지 URL

    private String address;          // 주소
    private String directions;       // 오시는 길
    private String openingTime;     // 영업 시작 시간
    private String closingTime;     // 영업 종료 시간
    private String phoneNumber;      // 전화번호
    private String businessType;     // 업종
    private String businessNumber;   // 사업자 등록 번호
    private LocalDateTime openingDate;   // 개업 일자

    private String certification; // 소상공인 확인서
    @Enumerated(EnumType.STRING)
    private StoreStatus status; // 승인 여부 (PENDING, APPROVED 등)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Menu> menuList = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cheer> cheerList = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StoreTag> storeTagList = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "location_id") // Store 테이블에 외래키로 location_id 생성
    private Location location;

    public static Store of(StoreRegisterRequest request) {
        return Store.builder()
                .name(request.name())
                .description(request.description())
                .address(request.address())
                .phoneNumber(request.phoneNumber())
                .businessType(request.businessType())
                .openingDate(request.openingDate())
                .businessNumber(request.businessNumber())
                .certification(request.certification())
                .status(StoreStatus.PENDING)
                .build();
    }


    // Helper methods for bidirectional relationship management
    // 응원 태그 추가
    public void addTag(TagType tagType) {
        for (StoreTag st : storeTagList) {
            if (st.getTagType() == tagType) {
                st.incrementCount();
                return;
            }
        }
        storeTagList.add(new StoreTag(this, tagType, 1));
    }

    public void addMenu(Menu menu) {
        this.menuList.add(menu);
        menu.setStore(this);
    }

    public void addCheer(Cheer cheer) {
        this.cheerList.add(cheer);
        cheer.setStore(this);
        this.incrementCheerCount();
    }

    public void incrementCheerCount() {
        this.cheerCount += 1;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void addStoreInfo(AddStoreInfoRequest request) {
        this.directions = request.directions();
        this.openingTime = request.openingTime();
        this.closingTime = request.closingTime();
        this.thumbnail = request.thumbnail();
    }
}
