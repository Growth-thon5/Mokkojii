package com.example.mokkoji.domain.tag.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true) // Added unique constraint for tag names
    private String name;

    @OneToMany(mappedBy = "tag", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CheerTag> cheerTagList = new ArrayList<>();

    @Builder
    public Tag(String name) {
        this.name = name;
    }

    // Helper method for bidirectional relationship management
    public void addCheerTag(CheerTag cheerTag) {
        this.cheerTagList.add(cheerTag);
        cheerTag.setTag(this);
    }
}
