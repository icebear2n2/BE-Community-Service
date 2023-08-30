package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.ArticleDto;
import com.icebear2n2.todayhouse.domain.dto.AvatarDto;
import com.icebear2n2.todayhouse.domain.entity.Like;
import com.icebear2n2.todayhouse.domain.entity.Scrap;
import lombok.Getter;

@Getter
public class ScrapResponse {
    private AvatarDto avatar;
    private ArticleDto article;

    public ScrapResponse(Scrap scrap) {
        this.avatar = new AvatarDto(scrap.getAvatar());
        this.article = new ArticleDto(scrap.getArticle());
    }
}
