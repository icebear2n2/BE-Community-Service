package com.icebear2n2.todayhouse.mediaPostLike.service;

import com.icebear2n2.todayhouse.avatar.repository.AvatarRepository;
import com.icebear2n2.todayhouse.domain.entity.Avatar;
import com.icebear2n2.todayhouse.domain.entity.MediaPost;
import com.icebear2n2.todayhouse.domain.entity.MediaPostLike;
import com.icebear2n2.todayhouse.domain.request.MediaPostLikeRequest;
import com.icebear2n2.todayhouse.domain.response.MediaPostLikeResponse;
import com.icebear2n2.todayhouse.mediaPost.repository.MediaPostRepository;
import com.icebear2n2.todayhouse.mediaPostLike.repository.MediaPostLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MediaPostLikeService {
    private final MediaPostLikeRepository mediaPostLikeRepository;
    private final MediaPostRepository mediaPostRepository;
    private final AvatarRepository avatarRepository;

    public void insert(MediaPostLikeRequest request) {
        Avatar avatar = avatarRepository.findById(request.avatarId()).orElseThrow(() -> new RuntimeException("AVATAR NOT FOUND!"));
        MediaPost mediaPost = mediaPostRepository.findById(request.mediaPostId()).orElseThrow(() -> new RuntimeException("MEDIA POST NOT FOUND."));
        MediaPostLike mediaPostLike = request.toEntity(avatar, mediaPost);
        mediaPostLikeRepository.save(mediaPostLike);
    }

    public Page<MediaPostLikeResponse> getAll(PageRequest request) {
        Page<MediaPostLike> all = mediaPostLikeRepository.findAll(request);
        return all.map(MediaPostLikeResponse::new);
    }

    public void delete(Long mediaPostLikeId) {
        mediaPostLikeRepository.deleteById(mediaPostLikeId);
    }
}
