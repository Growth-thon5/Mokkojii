package com.example.mokkoji.domain.cheer.entity;

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
@Table(name = "cheer_comment")
public class CheerComment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_comment_id")
    private CheerComment parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<CheerComment> children = new ArrayList<>();

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cheer_id")
    private Cheer cheer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public CheerComment(String content, User user, Cheer cheer, CheerComment parent) {
        this.content = content;
        this.user = user;
        this.cheer = cheer;
        if (parent != null) {
            this.parent = parent;
            parent.getChildren().add(this);
        }
    }

    // Helper methods for bidirectional relationship management
    public void setCheer(Cheer cheer) {
        this.cheer = cheer;
    }

    public void addChildComment(CheerComment child) {
        this.children.add(child);
        child.setParent(this);
    }

    public void setParent(CheerComment parent) {
        this.parent = parent;
    }
}
