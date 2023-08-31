package com.icebear2n2.todayhouse.domain.request;

import com.icebear2n2.todayhouse.domain.entity.Avatar;

public record AvatarRequest(String nickname, String gender, String picture, String about) {
    public Avatar toEntity() {
        return Avatar.builder().nickname(nickname).gender(gender).picture(picture).about(about).build();
    }
}
