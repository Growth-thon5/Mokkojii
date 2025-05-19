// 4. Store Entity
package com.example.mokkoji.domain.store.entity;

import com.example.mokkoji.domain.cheer.entity.Cheer;
import com.example.mokkoji.domain.tag.entity.StoreTag;
import com.example.mokkoji.domain.tag.entity.TagType;
import com.example.mokkoji.domain.user.entity.User;
import com.example.mokkoji.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

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

    @Embedded
    private StoreInfo storeInfo;

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
}
