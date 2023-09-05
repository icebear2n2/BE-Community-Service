package com.icebear2n2.todayhouse.tipPost.service;

import com.icebear2n2.todayhouse.avatar.repository.AvatarRepository;
import com.icebear2n2.todayhouse.config.exception.TipPostNotFoundException;
import com.icebear2n2.todayhouse.domain.entity.Avatar;
import com.icebear2n2.todayhouse.domain.entity.TipPost;
import com.icebear2n2.todayhouse.domain.request.TipPostRequest;
import com.icebear2n2.todayhouse.domain.response.TipPostResponse;
import com.icebear2n2.todayhouse.tipPost.repository.TipPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipPostService {

    private final TipPostRepository tipPostRepository;
    private final AvatarRepository avatarRepository;

    //    TODO: Tip POST CRUD
//    TODO: Tip POST CREATE
    public void insert(TipPostRequest request) {
        Avatar avatar = avatarRepository.findById(request.avatarId()).orElseThrow(TipPostNotFoundException::new);
        tipPostRepository.save(request.toEntity(avatar));
    }

    //    TODO: Tip POST READ
    public Page<TipPostResponse> getAll(PageRequest request) {
        Page<TipPost> all = tipPostRepository.findAll(request);
        return all.map(TipPostResponse::new);
    }


    //    TODO: Tip POST UPDATE
    public TipPostResponse update(Long tipPostId, TipPostRequest request) {
        TipPost tipPost = tipPostRepository.findById(tipPostId).orElseThrow(TipPostNotFoundException::new);
        tipPost.UpdateTipPost(request.link(), request.linkInfo(), request.title(), request.content());
        tipPostRepository.save(tipPost);
        return new TipPostResponse(tipPost);
    }

    //    TODO: Tip POST DELETE
    public void delete(Long tipPostId) {
        TipPost tipPost = tipPostRepository.findById(tipPostId).orElseThrow(TipPostNotFoundException::new);
        tipPostRepository.deleteById(tipPost.getTipPostId());
    }
}
