package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.ArticleDto;
import com.icebear2n2.todayhouse.domain.dto.AvatarDto;
import com.icebear2n2.todayhouse.domain.dto.CommentDto;
import com.icebear2n2.todayhouse.domain.entity.Comment;
import lombok.Getter;

@Getter
public class CommentResponse extends CommentDto {

    private AvatarDto avatar;
    private ArticleDto article;
    public CommentResponse(Comment comment) {
        super(comment);
        avatar = new AvatarDto(comment.getAvatar());
        article = new ArticleDto(comment.getArticle());
    }
}
