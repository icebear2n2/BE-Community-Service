package com.icebear2n2.todayhouse.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "comment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "avatar_id", referencedColumnName = "avatar_id")
    private Avatar avatar;

    @ManyToOne
    @JoinColumn(name = "house_tour_id", referencedColumnName = "house_tour_id")
    private HouseTour houseTour;

    @ManyToOne
    @JoinColumn(name = "media_post_id", referencedColumnName = "media_post_id")
    private MediaPost mediaPost;

    @ManyToOne
    @JoinColumn(name = "tip_post_id", referencedColumnName = "tip_post_id")
    private TipPost tipPost;

    private String content;

    @CreationTimestamp
    private Timestamp createdAt;
}
