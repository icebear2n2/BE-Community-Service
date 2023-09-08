package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.AvatarDto;
import com.icebear2n2.todayhouse.domain.dto.HouseTourDto;
import com.icebear2n2.todayhouse.domain.dto.MediaPostDto;
import com.icebear2n2.todayhouse.domain.entity.HouseTourScrap;
import com.icebear2n2.todayhouse.domain.entity.MediaPostScrap;
import lombok.Getter;

@Getter
public class MediaPostScrapResponse {
    private AvatarDto avatar;
    private MediaPostDto mediaPost;

    public MediaPostScrapResponse(MediaPostScrap mediaPostScrap) {
        this.avatar = new AvatarDto(mediaPostScrap.getAvatar());
        this.mediaPost = new MediaPostDto(mediaPostScrap.getMediaPost());
    }
}
