package com.icebear2n2.todayhouse.houseTourComment.service;

import com.icebear2n2.todayhouse.avatar.repository.AvatarRepository;
import com.icebear2n2.todayhouse.domain.entity.Avatar;
import com.icebear2n2.todayhouse.domain.entity.HouseTour;
import com.icebear2n2.todayhouse.domain.entity.HouseTourComment;
import com.icebear2n2.todayhouse.domain.request.HouseTourCommentRequest;
import com.icebear2n2.todayhouse.domain.response.HouseTourCommentResponse;
import com.icebear2n2.todayhouse.houseTour.repository.HouseTourRepository;
import com.icebear2n2.todayhouse.houseTourComment.repository.HouseTourCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HouseTourCommentService {
    private final HouseTourCommentRepository houseTourCommentRepository;
    private final AvatarRepository avatarRepository;
    private final HouseTourRepository houseTourRepository;

    //    TODO: Comment CRUD
//    TODO : Comment CREATE
    public void insert(HouseTourCommentRequest request) {
        Avatar avatar = avatarRepository.findById(request.avatarId()).orElseThrow(() -> new RuntimeException("AVATAR NOT FOUND!"));
        HouseTour houseTour = houseTourRepository.findById(request.houseTourId()).orElseThrow(() -> new RuntimeException("POST NOT FOUND!"));
        HouseTourComment houseTourComment = request.toEntity(avatar, houseTour);
        houseTourCommentRepository.save(houseTourComment);
    }

    //    TODO: Comment READ
    public Page<HouseTourCommentResponse> getAll(PageRequest request) {
        Page<HouseTourComment> all = houseTourCommentRepository.findAll(request);
        return all.map(HouseTourCommentResponse::new);
    }
//    TODO: Comment UPDATE

    //    TODO: Comment DELETE
    public void delete(Long houseTourCommentId) {
        houseTourCommentRepository.deleteById(houseTourCommentId);
    }
}
