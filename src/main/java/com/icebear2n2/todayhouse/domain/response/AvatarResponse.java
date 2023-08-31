package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.AvatarDto;
import com.icebear2n2.todayhouse.domain.dto.UserDto;
import com.icebear2n2.todayhouse.domain.entity.Avatar;
import com.icebear2n2.todayhouse.domain.entity.UserAvatar;
import lombok.Getter;

import java.util.List;

@Getter
public class AvatarResponse extends AvatarDto {
    private List<UserDto> users;

    public AvatarResponse(Avatar avatar) {
        super(avatar);
        users = avatar.getUsers().stream().map(UserAvatar::getUser).map(UserDto::new).toList();
    }
}
