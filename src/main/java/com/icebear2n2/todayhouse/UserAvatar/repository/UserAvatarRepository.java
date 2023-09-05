package com.icebear2n2.todayhouse.UserAvatar.repository;


import com.icebear2n2.todayhouse.domain.entity.Avatar;
import com.icebear2n2.todayhouse.domain.entity.User;
import com.icebear2n2.todayhouse.domain.entity.UserAvatar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAvatarRepository extends JpaRepository<UserAvatar, Long> {
    Page<UserAvatar> findAll(Pageable request);

    Boolean existsByAvatarOrUser(Avatar avatar, User user);
}
