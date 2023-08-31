package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.AvatarDto;
import com.icebear2n2.todayhouse.domain.dto.UserDto;
import com.icebear2n2.todayhouse.domain.entity.User;
import com.icebear2n2.todayhouse.domain.entity.UserAvatar;
import lombok.Getter;

import java.util.List;

@Getter
public class UserResponse extends UserDto {

    private List<AvatarDto> avatars;

    public UserResponse(User user) {
        super(user);
        avatars = user.getAvatars().stream().map(UserAvatar::getAvatar).map(AvatarDto::new).toList();
    }
}
