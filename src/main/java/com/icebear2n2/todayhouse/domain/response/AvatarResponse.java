package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.*;
import com.icebear2n2.todayhouse.domain.entity.Avatar;
import com.icebear2n2.todayhouse.domain.entity.HouseTour;
import com.icebear2n2.todayhouse.domain.entity.TipPost;
import com.icebear2n2.todayhouse.domain.entity.UserAvatar;
import lombok.Getter;

import java.util.List;

@Getter
public class AvatarResponse extends AvatarDto {
    private List<UserDto> users;
    private List<HouseTourDto> houseTours;
    private List<MediaPostDto> mediaPosts;
    private List<TipPostDto> tipPosts;

    public AvatarResponse(Avatar avatar) {
        super(avatar);
        users = avatar.getUsers().stream().map(UserAvatar::getUser).map(UserDto::new).toList();
        houseTours = avatar.getHouseTours().stream().map(HouseTourDto::new).toList();
        mediaPosts = avatar.getMediaPosts().stream().map(MediaPostDto::new).toList();
        tipPosts = avatar.getTipPosts().stream().map(TipPostDto::new).toList();
    }
}
