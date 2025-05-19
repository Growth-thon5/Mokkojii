package com.example.mokkoji.domain.cheer.entity;

import com.example.mokkoji.domain.user.entity.User;
import com.example.mokkoji.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "cheer_comment")
public class CheerComment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cheer_id")
    private Cheer cheer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public CheerComment(String content, User user, Cheer cheer) {
        this.content = content;
        this.user = user;
        this.cheer = cheer;
    }

    // 연관관계 편의 메서드
    public void setCheer(Cheer cheer) {
        this.cheer = cheer;
    }
}
