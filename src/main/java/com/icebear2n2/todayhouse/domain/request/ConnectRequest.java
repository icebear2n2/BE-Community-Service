package com.icebear2n2.todayhouse.domain.request;

import com.icebear2n2.todayhouse.domain.entity.UserAvatar;

import java.util.UUID;

public record ConnectRequest(UUID userId, Long avatarId) {
}
