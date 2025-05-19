package com.example.mokkoji.domain.cheer.entity;
import com.example.mokkoji.domain.store.entity.Store;
import com.example.mokkoji.domain.tag.entity.TagType;
import com.example.mokkoji.domain.user.entity.User;
import com.example.mokkoji.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@Getter @NoArgsConstructor
@Table(name = "cheer")
public class Cheer extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "cheer_tag", joinColumns = @JoinColumn(name = "cheer_id"))
    @Column(name = "tag_type")
    private List<TagType> cheerTagList = new ArrayList<>();


    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "cheer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CheerComment> cheerCommentList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;


    public static Cheer of(User user, String content, Store store) {
        return Cheer.builder()
                .user(user)
                .content(content)
                .store(store)
                .cheerTagList(new ArrayList<>())
                .build();
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
