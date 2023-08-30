package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.ArticleDto;
import com.icebear2n2.todayhouse.domain.dto.AvatarDto;
import com.icebear2n2.todayhouse.domain.entity.Avatar;
import com.icebear2n2.todayhouse.domain.entity.Follow;
import com.icebear2n2.todayhouse.domain.entity.Like;
import lombok.Getter;

@Getter
public class LikeResponse {
    private AvatarDto avatar;
    private ArticleDto article;

    public LikeResponse(Like like) {
        this.avatar = new AvatarDto(like.getAvatar());
        this.article = new ArticleDto(like.getArticle());
    }
}
