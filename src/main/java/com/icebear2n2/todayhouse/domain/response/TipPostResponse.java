package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.AvatarDto;
import com.icebear2n2.todayhouse.domain.dto.TipPostCommentDto;
import com.icebear2n2.todayhouse.domain.dto.TipPostDto;
import com.icebear2n2.todayhouse.domain.entity.TipPost;
import lombok.Getter;

import java.util.List;

@Getter
public class TipPostResponse extends TipPostDto {

    private AvatarDto avatar;
    private List<TipPostCommentDto> comments;

    public TipPostResponse(TipPost tipPost) {
        super(tipPost);
        avatar = new AvatarDto(tipPost.getAvatar());
        comments = tipPost.getComments().stream().map(TipPostCommentDto::new).toList();
    }
}
