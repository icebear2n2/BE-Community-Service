package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.HouseTourDto;
import com.icebear2n2.todayhouse.domain.dto.AvatarDto;
import com.icebear2n2.todayhouse.domain.dto.MediaPostDto;
import com.icebear2n2.todayhouse.domain.dto.TipPostDto;
import com.icebear2n2.todayhouse.domain.entity.Like;
import lombok.Getter;

@Getter
public class LikeResponse {
    private AvatarDto avatar;
    private HouseTourDto houseTour;
    private MediaPostDto mediaPost;
    private TipPostDto tipPost;

    public LikeResponse(Like like) {
        this.avatar = new AvatarDto(like.getAvatar());
        this.houseTour = new HouseTourDto(like.getHouseTour());
        this.mediaPost = new MediaPostDto(like.getMediaPost());
        this.tipPost = new TipPostDto(like.getTipPost());
    }
}
