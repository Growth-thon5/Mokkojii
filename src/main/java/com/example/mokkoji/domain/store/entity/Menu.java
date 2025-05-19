package com.example.mokkoji.domain.store.entity;

import com.example.mokkoji.domain.store.controller.dto.request.MenuRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "menu")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl; // 이미지 저장된 경로 또는 URL
    private String menuName; // 메뉴 이름
    private String menuDescription; // 메뉴 설명

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id") // Changed from post_id to store_id for consistency
    private Store store;

    // Helper method for bidirectional relationship management
    public void setStore(Store store) {
        this.store = store;
        if (!store.getMenuList().contains(this)) {
            store.getMenuList().add(this);
        }
    }

    //
    public static Menu of(MenuRequest menuRequest) {
        return Menu.builder()
                .menuName(menuRequest.name())
                .menuDescription(menuRequest.description())
                .imageUrl(menuRequest.imageUrl())
                .build();
    }
}
