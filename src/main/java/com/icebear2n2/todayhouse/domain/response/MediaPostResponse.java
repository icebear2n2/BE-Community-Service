package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.AvatarDto;
import com.icebear2n2.todayhouse.domain.dto.MediaPostCommentDto;
import com.icebear2n2.todayhouse.domain.dto.MediaPostDto;
import com.icebear2n2.todayhouse.domain.entity.MediaPost;
import lombok.Getter;

import java.util.List;

@Getter
public class MediaPostResponse extends MediaPostDto {

    private AvatarDto avatar;
    private List<MediaPostCommentDto> comments;

    public MediaPostResponse(MediaPost mediaPost) {

        super(mediaPost);
        avatar = new AvatarDto(mediaPost.getAvatar());
        comments = mediaPost.getComments().stream().map(MediaPostCommentDto::new).toList();
    }
}
