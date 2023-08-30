package com.icebear2n2.todayhouse.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "like")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long likeId;

    @ManyToOne
    @JoinColumn(name = "avatar_id", referencedColumnName = "avatar_id")
    private Avatar avatar;

    @ManyToOne
    @JoinColumn(name = "article_id", referencedColumnName = "article_id")
    private Article article;
}
