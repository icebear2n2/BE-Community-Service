package com.icebear2n2.todayhouse.domain.request;

import com.icebear2n2.todayhouse.domain.entity.UserAvatar;

public record ConnectRequest(Long userId, Long avatarId) {
}
