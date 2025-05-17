package com.example.mokkoji.domain.tag.entity;

import com.example.mokkoji.domain.cheer.entity.Cheer;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter @NoArgsConstructor
@Table(name = "cheer_tag")
public class CheerTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cheer_id")
    private Cheer cheer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @Builder
    public CheerTag(Cheer cheer, Tag tag) {
        this.setCheer(cheer);
        this.setTag(tag);
    }

    // Helper methods for bidirectional relationship management
    public void setCheer(Cheer cheer) {
        this.cheer = cheer;
        if (!cheer.getCheerTagList().contains(this)) {
            cheer.getCheerTagList().add(this);
        }
    }

    public void setTag(Tag tag) {
        this.tag = tag;
        if (!tag.getCheerTagList().contains(this)) {
            tag.getCheerTagList().add(this);
        }
    }
}
