package com.icebear2n2.todayhouse.domain.dto;

import com.icebear2n2.todayhouse.domain.entity.Comment;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class CommentDto {
    private Long commentId;
    private String content;
    private Timestamp createdAt;

    public CommentDto(Comment comment) {
        this.commentId = comment.getCommentId();
        this.content = comment.getContent();
        this.createdAt = comment.getCreatedAt();
    }
}
