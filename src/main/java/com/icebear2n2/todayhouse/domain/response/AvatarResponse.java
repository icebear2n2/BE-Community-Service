package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.*;
import com.icebear2n2.todayhouse.domain.entity.*;
import lombok.Getter;

import java.util.List;

@Getter
public class AvatarResponse extends AvatarDto {
    private List<UserDto> users;
    private List<HouseTourDto> houseTours;
    private List<MediaPostDto> mediaPosts;
    private List<TipPostDto> tipPosts;
    private List<AvatarDto> followers;
    private List<AvatarDto> followings;

    public AvatarResponse(Avatar avatar) {
        super(avatar);
        users = avatar.getUsers().stream().map(UserAvatar::getUser).map(UserDto::new).toList();
        houseTours = avatar.getHouseTours().stream().map(HouseTourDto::new).toList();
        mediaPosts = avatar.getMediaPosts().stream().map(MediaPostDto::new).toList();
        tipPosts = avatar.getTipPosts().stream().map(TipPostDto::new).toList();
        followers = avatar.getFollowerList().stream().map(Follow::getFollower).map(AvatarDto::new).toList();
        followings = avatar.getFollowingList().stream().map(Follow::getFollowing).map(AvatarDto::new).toList();
    }
}
