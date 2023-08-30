package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.CommentDto;
import com.icebear2n2.todayhouse.domain.dto.PostDto;
import com.icebear2n2.todayhouse.domain.dto.UserDto;
import com.icebear2n2.todayhouse.domain.entity.Comment;
import lombok.Getter;

@Getter
public class CommentResponse extends CommentDto {

    private UserDto user;
    private PostDto post;

    public CommentResponse(Comment comment) {
        super(comment);
        user = new UserDto(comment.getUser());
        post = new PostDto(comment.getPost());
    }
}
