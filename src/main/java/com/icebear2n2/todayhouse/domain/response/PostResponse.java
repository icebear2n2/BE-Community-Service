package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.PostDto;
import com.icebear2n2.todayhouse.domain.dto.UserDto;
import com.icebear2n2.todayhouse.domain.entity.Post;
import lombok.Getter;

@Getter
public class PostResponse extends PostDto {

    private UserDto user;

    public PostResponse(Post post) {
        super(post);
        user = new UserDto(post.getUser());
    }
}
