package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.AvatarDto;
import com.icebear2n2.todayhouse.domain.dto.UserDto;
import com.icebear2n2.todayhouse.domain.entity.User;
import lombok.Getter;

@Getter
public class UserResponse extends UserDto {

    private AvatarDto avatar;

    public UserResponse(User user) {
        super(user);
        avatar = new AvatarDto(user.getAvatar());
    }
}
