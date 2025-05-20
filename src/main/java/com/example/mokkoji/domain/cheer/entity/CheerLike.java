package com.example.mokkoji.domain.cheer.entity;

import com.example.mokkoji.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "cheer_like", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "cheer_id"})
})
public class CheerLike {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cheer_id")
    private Cheer cheer;
}

