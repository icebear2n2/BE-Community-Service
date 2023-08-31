package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.ArticleDto;
import com.icebear2n2.todayhouse.domain.dto.CommentDto;
import com.icebear2n2.todayhouse.domain.entity.Article;
import lombok.Getter;

import java.util.List;

@Getter
public class ArticleResponse extends ArticleDto {

    private List<CommentDto> comments;
    public ArticleResponse(Article article) {
        super(article);
        comments = article.getComments().stream().map(CommentDto::new).toList();
    }
}
