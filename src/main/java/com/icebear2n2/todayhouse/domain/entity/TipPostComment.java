package com.icebear2n2.todayhouse.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "tip_post_comment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class TipPostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tipPostCommentId;

    @ManyToOne
    private Avatar avatar;

    @ManyToOne
    private TipPost tipPost;

    private String content;
    private Timestamp createdAt;
}
