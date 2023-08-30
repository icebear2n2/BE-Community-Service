package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.AvatarDto;
import com.icebear2n2.todayhouse.domain.entity.Avatar;
import lombok.Getter;

@Getter
public class AvatarResponse extends AvatarDto {
    public AvatarResponse(Avatar avatar) {
        super(avatar);
    }
}
