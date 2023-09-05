package com.icebear2n2.todayhouse.tipPostLike.service;

import com.icebear2n2.todayhouse.avatar.repository.AvatarRepository;
import com.icebear2n2.todayhouse.domain.entity.Avatar;
import com.icebear2n2.todayhouse.domain.entity.TipPost;
import com.icebear2n2.todayhouse.domain.entity.TipPostLike;
import com.icebear2n2.todayhouse.domain.request.TipPostLikeRequest;
import com.icebear2n2.todayhouse.domain.response.TipPostLikeResponse;
import com.icebear2n2.todayhouse.tipPost.repository.TipPostRepository;
import com.icebear2n2.todayhouse.tipPostLike.repository.TipPostLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipPostLikeService {
    private final TipPostLikeRepository tipPostLikeRepository;
    private final TipPostRepository tipPostRepository;
    private final AvatarRepository avatarRepository;

    public void insert(TipPostLikeRequest request) {
        Avatar avatar = avatarRepository.findById(request.avatarId()).orElseThrow(() -> new RuntimeException("AVATAR NOT FOUND!"));
        TipPost tipPost = tipPostRepository.findById(request.tipPostId()).orElseThrow(() -> new RuntimeException("Tip Post NOT FOUND!"));
        Boolean existsByAvatarAvatarIdAndTipPostTipPostId = tipPostLikeRepository.existsByAvatar_AvatarIdAndTipPost_TipPostId(avatar.getAvatarId(), tipPost.getTipPostId());
        if (!existsByAvatarAvatarIdAndTipPostTipPostId) {
            TipPostLike tipPostLike = request.toEntity(avatar, tipPost);
            tipPostLikeRepository.save(tipPostLike);
        } else {
            throw new RuntimeException("Already Like Post.");
        }
    }

    public Page<TipPostLikeResponse> getAll(PageRequest request) {
        Page<TipPostLike> all = tipPostLikeRepository.findAll(request);
        return all.map(TipPostLikeResponse::new);
    }

    public void delete(Long tipPostLikeId) {
        tipPostLikeRepository.deleteById(tipPostLikeId);
    }
}
