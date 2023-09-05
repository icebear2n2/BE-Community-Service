package com.icebear2n2.todayhouse.avatar.repository;

import com.icebear2n2.todayhouse.domain.entity.Avatar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {
    Page<Avatar> findAll(Pageable request);

    Boolean existsByNickname(String nickName);
}
