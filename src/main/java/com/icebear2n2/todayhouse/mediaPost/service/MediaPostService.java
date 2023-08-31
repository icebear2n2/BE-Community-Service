package com.icebear2n2.todayhouse.mediaPost.service;

import com.icebear2n2.todayhouse.avatar.repository.AvatarRepository;
import com.icebear2n2.todayhouse.domain.entity.Avatar;
import com.icebear2n2.todayhouse.domain.entity.MediaPost;
import com.icebear2n2.todayhouse.domain.request.MediaPostRequest;
import com.icebear2n2.todayhouse.domain.response.MediaPostResponse;
import com.icebear2n2.todayhouse.mediaPost.repository.MediaPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MediaPostService {
    private final MediaPostRepository mediaPostRepository;
    private final AvatarRepository avatarRepository;

    //    TODO: MediaPOST CREATE
    public void insert(MediaPostRequest request) {
        Avatar avatar = avatarRepository.findById(request.avatarId()).orElseThrow(() -> new RuntimeException("AVATAR NOT FOUND!"));
        mediaPostRepository.save(request.toEntity(avatar));
    }

    //    TODO: MediaPOST READ
    public Page<MediaPostResponse> getAll(PageRequest request) {
        Page<MediaPost> all = mediaPostRepository.findAll(request);
        return all.map(MediaPostResponse::new);
    }


    //    TODO: MediaPOST DELETE

    public void delete(Long mediaPostId) {
        mediaPostRepository.deleteById(mediaPostId);
    }
}
