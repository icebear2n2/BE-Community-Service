package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.AvatarDto;
import com.icebear2n2.todayhouse.domain.dto.UserDto;
import com.icebear2n2.todayhouse.domain.entity.UserAvatar;
import lombok.Getter;

@Getter
public class UserAvatarResponse {

    private Long id;
    private UserDto user;
    private AvatarDto avatar;

    public UserAvatarResponse(UserAvatar userAvatar) {
        id = userAvatar.getId();
        this.user = new UserDto(userAvatar.getUser());
        this.avatar = new AvatarDto(userAvatar.getAvatar());
    }
}
