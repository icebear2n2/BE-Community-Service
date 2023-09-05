package com.icebear2n2.todayhouse.houseTourLike.service;

import com.icebear2n2.todayhouse.avatar.repository.AvatarRepository;
import com.icebear2n2.todayhouse.config.exception.AvatarNotFoundException;
import com.icebear2n2.todayhouse.config.exception.ExistLikeException;
import com.icebear2n2.todayhouse.config.exception.HouseTourNotFoundException;
import com.icebear2n2.todayhouse.config.exception.LikeNotFoundException;
import com.icebear2n2.todayhouse.domain.entity.Avatar;
import com.icebear2n2.todayhouse.domain.entity.HouseTour;
import com.icebear2n2.todayhouse.domain.entity.HouseTourLike;
import com.icebear2n2.todayhouse.domain.request.HouseTourLikeRequest;
import com.icebear2n2.todayhouse.domain.response.HouseTourLikeResponse;
import com.icebear2n2.todayhouse.houseTour.repository.HouseTourRepository;
import com.icebear2n2.todayhouse.houseTourLike.repository.HouseTourLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HouseTourLikeService {
    private final HouseTourLikeRepository houseTourLikeRepository;
    private final AvatarRepository avatarRepository;
    private final HouseTourRepository houseTourRepository;

//    TODO: Like CRD

    //    TODO: Like CREATE
    public void insert(HouseTourLikeRequest request) {
        Avatar avatar = avatarRepository.findById(request.avatarId()).orElseThrow(AvatarNotFoundException::new);
        HouseTour houseTour = houseTourRepository.findById(request.houseTourId()).orElseThrow(HouseTourNotFoundException::new);
        Boolean existsByAvatarAvatarIdAndHouseTourHouseTourId = houseTourLikeRepository.existsByAvatar_AvatarIdAndHouseTour_HouseTourId(avatar.getAvatarId(), houseTour.getHouseTourId());
        if (!existsByAvatarAvatarIdAndHouseTourHouseTourId) {
            HouseTourLike houseTourLike = request.toEntity(avatar, houseTour);
            houseTourLikeRepository.save(houseTourLike);
        } else {
            throw new ExistLikeException();
        }

    }

    //    TODO: Like READ
    public Page<HouseTourLikeResponse> getAll(PageRequest request) {
        Page<HouseTourLike> all = houseTourLikeRepository.findAll(request);
        return all.map(HouseTourLikeResponse::new);
    }

    //    TODO: Like DELETE
    public void delete(Long houseTourLikeId) {
        HouseTourLike houseTourLike = houseTourLikeRepository.findById(houseTourLikeId).orElseThrow(LikeNotFoundException::new);
        houseTourLikeRepository.deleteById(houseTourLike.getLikeId());
    }
}
