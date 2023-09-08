package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.AvatarDto;
import com.icebear2n2.todayhouse.domain.dto.HouseTourDto;
import com.icebear2n2.todayhouse.domain.entity.HouseTourLike;
import com.icebear2n2.todayhouse.domain.entity.HouseTourScrap;
import lombok.Getter;

@Getter
public class HouseTourScrapResponse {
    private AvatarDto avatar;
    private HouseTourDto houseTour;

    public HouseTourScrapResponse(HouseTourScrap houseTourScrap) {
        this.avatar = new AvatarDto(houseTourScrap.getAvatar());
        this.houseTour = new HouseTourDto(houseTourScrap.getHouseTour());
    }
}
