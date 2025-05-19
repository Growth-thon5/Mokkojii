package com.example.mokkoji.domain.cheer.entity;
import com.example.mokkoji.domain.store.entity.Store;
import com.example.mokkoji.domain.tag.entity.CheerTag;
import com.example.mokkoji.domain.user.entity.User;
import com.example.mokkoji.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @NoArgsConstructor
@Table(name = "cheer")
public class Cheer extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "cheer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CheerTag> cheerTagList = new ArrayList<>();

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "cheer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CheerComment> cheerCommentList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @Builder
    public Cheer(String content, User user, Store store) {
        this.content = content;
        this.user = user;
        this.store = store;
    }

    // Helper methods for bidirectional relationship management
    public void addCheerTag(CheerTag cheerTag) {
        this.cheerTagList.add(cheerTag);
    }

    public void addCheerComment(CheerComment cheerComment) {
        this.cheerCommentList.add(cheerComment);
        cheerComment.setCheer(this);
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setStore(Store store) {
        this.store = store;
        store.getCheerList().add(this);
        store.incrementCheerCount();
    }

}
