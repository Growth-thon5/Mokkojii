package com.example.mokkoji.domain.tag.entity;

import com.example.mokkoji.domain.store.entity.Store;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class StoreTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;

    @Enumerated(EnumType.STRING)
    private TagType tagType;

    private int count;

    public StoreTag(Store store, TagType tagType, int count) {
        this.store = store;
        this.tagType = tagType;
        this.count = count;
    }

    public StoreTag(Store store, TagType tagType) {
        this.store = store;
        this.tagType = tagType;
        this.count = 1;
    }

    public void incrementCount() {
        this.count += 1;
    }
}
