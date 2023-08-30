package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.PostDto;
import com.icebear2n2.todayhouse.domain.dto.UserDto;
import com.icebear2n2.todayhouse.domain.entity.Scrap;
import lombok.Getter;

@Getter
public class ScrapResponse {
    private UserDto user;
    private PostDto post;

    public ScrapResponse(Scrap scrap) {
        this.user = new UserDto(scrap.getUser());
        this.post = new PostDto(scrap.getPost());
    }
}
