package com.icebear2n2.todayhouse.tipPostComment.service;

import com.icebear2n2.todayhouse.avatar.repository.AvatarRepository;
import com.icebear2n2.todayhouse.domain.entity.Avatar;
import com.icebear2n2.todayhouse.domain.entity.MediaPost;
import com.icebear2n2.todayhouse.domain.entity.TipPost;
import com.icebear2n2.todayhouse.domain.entity.TipPostComment;
import com.icebear2n2.todayhouse.domain.request.TipPostCommentRequest;
import com.icebear2n2.todayhouse.domain.response.TipPostCommentResponse;
import com.icebear2n2.todayhouse.tipPost.repository.TipPostRepository;
import com.icebear2n2.todayhouse.tipPostComment.repository.TipPostCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipPostCommentService {
    private final TipPostCommentRepository tipPostCommentRepository;
    private final AvatarRepository avatarRepository;
    private final TipPostRepository tipPostRepository;

    //    TODO: Comment CRUD
//    TODO: Comment CREATE
    public void insert(TipPostCommentRequest request) {
        Avatar avatar = avatarRepository.findById(request.avatarId()).orElseThrow(() -> new RuntimeException("AVATAR NOT FOUND!"));
        TipPost tipPost = tipPostRepository.findById(request.tipPostId()).orElseThrow(() -> new RuntimeException("POST NOT FOUND!"));
        TipPostComment tipPostComment = request.toEntity(avatar, tipPost);
        tipPostCommentRepository.save(tipPostComment);
    }

    //    TODO: Comment READ
    public Page<TipPostCommentResponse> getAll(PageRequest request) {
        Page<TipPostComment> all = tipPostCommentRepository.findAll(request);
        return all.map(TipPostCommentResponse::new);
    }

    //    TODO: Comment UPDATE
//    TODO: Comment DELETE
    public void delete(Long tipPostCommentId) {
        tipPostCommentRepository.deleteById(tipPostCommentId);
    }
}
