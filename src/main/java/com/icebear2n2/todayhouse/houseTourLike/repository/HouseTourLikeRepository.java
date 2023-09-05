package com.icebear2n2.todayhouse.houseTourLike.repository;

import com.icebear2n2.todayhouse.domain.entity.Avatar;
import com.icebear2n2.todayhouse.domain.entity.HouseTour;
import com.icebear2n2.todayhouse.domain.entity.HouseTourLike;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseTourLikeRepository extends JpaRepository<HouseTourLike, Long> {
    Page<HouseTourLike> findAll(Pageable request);

    Boolean existsByAvatar_AvatarIdAndHouseTour_HouseTourId(Long avatarId, Long houseTourId);
}
