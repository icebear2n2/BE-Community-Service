package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.PostDto;
import com.icebear2n2.todayhouse.domain.dto.UserDto;
import com.icebear2n2.todayhouse.domain.entity.Like;
import lombok.Getter;

@Getter
public class LikeResponse {
    private UserDto user;
    private PostDto post;

    public LikeResponse(Like like) {
        this.user = new UserDto(like.getUser());
        this.post = new PostDto(like.getPost());
    }
}
