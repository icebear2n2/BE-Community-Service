package com.icebear2n2.todayhouse.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "media_post_comment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class MediaPostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mediaPostCommentId;

    @ManyToOne
    private Avatar avatar;

    @ManyToOne
    private MediaPost mediaPost;

    private String content;
    private Timestamp createdAt;
}
