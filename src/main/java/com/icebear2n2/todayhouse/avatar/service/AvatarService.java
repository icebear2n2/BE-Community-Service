package com.icebear2n2.todayhouse.avatar.service;

import com.icebear2n2.todayhouse.avatar.repository.AvatarRepository;
import com.icebear2n2.todayhouse.domain.entity.Avatar;
import com.icebear2n2.todayhouse.domain.entity.User;
import com.icebear2n2.todayhouse.domain.request.AvatarRequest;
import com.icebear2n2.todayhouse.domain.response.AvatarResponse;
import com.icebear2n2.todayhouse.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvatarService {

    private final AvatarRepository avatarRepository;
    private final UserRepository userRepository;

//    TODO: Avatar CRUD

    //    TODO: Avatar CREATE
    public void insert(AvatarRequest request) {
        Avatar avatar = request.toEntity();
        avatarRepository.save(avatar);
    }

//    TODO: Avatar READ

    public Page<AvatarResponse> getAll(PageRequest request) {
        Page<Avatar> all = avatarRepository.findAll(request);
        return all.map(AvatarResponse::new);
    }

    //    TODO: Avatar UPDATE -> 수정 필요!!
    public AvatarResponse update(Long avatarId, AvatarRequest request) {
        Avatar oldAvatar = avatarRepository.findById(avatarId).orElseThrow(() -> new RuntimeException("AVATAR NOT FOUND!"));
        Avatar avatar = new Avatar(oldAvatar.getAvatarId(), request.nickname(), request.gender(), request.picture(), request.about(), oldAvatar.getUsers(), oldAvatar.getHouseTours(), oldAvatar.getMediaPosts(), oldAvatar.getTipPosts());
        Avatar save = avatarRepository.save(avatar);
        return new AvatarResponse(save);
    }

//    TODO: Avatar DELETE

    public void delete(Long avatarId) {
        avatarRepository.deleteById(avatarId);
    }

}
