package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.AvatarDto;
import com.icebear2n2.todayhouse.domain.dto.MediaPostDto;
import com.icebear2n2.todayhouse.domain.dto.TipPostDto;
import com.icebear2n2.todayhouse.domain.entity.MediaPostScrap;
import com.icebear2n2.todayhouse.domain.entity.TipPostScrap;
import lombok.Getter;

@Getter
public class TipPostScrapResponse {
    private AvatarDto avatar;
    private TipPostDto tipPost;

    public TipPostScrapResponse(TipPostScrap tipPostScrap) {
        this.avatar = new AvatarDto(tipPostScrap.getAvatar());
        this.tipPost = new TipPostDto(tipPostScrap.getTipPost());
    }
}
