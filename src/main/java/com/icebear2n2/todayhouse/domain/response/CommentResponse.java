package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.*;
import com.icebear2n2.todayhouse.domain.entity.Comment;
import lombok.Getter;

@Getter
public class CommentResponse extends CommentDto {

    private AvatarDto avatar;
    private HouseTourDto houseTour;
    private MediaPostDto mediaPost;
    private TipPostDto tipPost;

    public CommentResponse(Comment comment) {
        super(comment);
        avatar = new AvatarDto(comment.getAvatar());
        this.houseTour = new HouseTourDto(comment.getHouseTour());
        this.mediaPost = new MediaPostDto(comment.getMediaPost());
        this.tipPost = new TipPostDto(comment.getTipPost());
    }
}
