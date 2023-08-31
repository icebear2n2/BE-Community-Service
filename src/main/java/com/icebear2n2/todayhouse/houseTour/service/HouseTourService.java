package com.icebear2n2.todayhouse.houseTour.service;

import com.icebear2n2.todayhouse.avatar.repository.AvatarRepository;
import com.icebear2n2.todayhouse.domain.entity.Avatar;
import com.icebear2n2.todayhouse.domain.entity.HouseTour;
import com.icebear2n2.todayhouse.domain.request.HouseTourRequest;
import com.icebear2n2.todayhouse.domain.response.HouseTourResponse;
import com.icebear2n2.todayhouse.houseTour.repository.HouseTourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HouseTourService {

    private final HouseTourRepository houseTourRepository;
    private final AvatarRepository avatarRepository;

    //    TODO: HouseTour CRUD

    //    TODO: HouseTour CREATE
    public void insert(HouseTourRequest request) {
        Avatar avatar = avatarRepository.findById(request.avatarId()).orElseThrow(() -> new RuntimeException("AVATAR NOT FOUND!"));
        houseTourRepository.save(request.toEntity(avatar));
    }

//    TODO: HouseTour READ

    public Page<HouseTourResponse> getAll(PageRequest request) {
        Page<HouseTour> all = houseTourRepository.findAll(request);
        return all.map(HouseTourResponse::new);
    }

//    TODO: HouseTour UPDATE

    //    TODO: HouseTour DELETE
    public void delete(Long houseTourId) {
        houseTourRepository.deleteById(houseTourId);
    }
}