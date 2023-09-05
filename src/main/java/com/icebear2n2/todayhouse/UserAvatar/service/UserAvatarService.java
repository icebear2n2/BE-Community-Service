package com.icebear2n2.todayhouse.UserAvatar.service;

import com.icebear2n2.todayhouse.UserAvatar.repository.UserAvatarRepository;
import com.icebear2n2.todayhouse.avatar.repository.AvatarRepository;
import com.icebear2n2.todayhouse.config.exception.AvatarNotFoundException;
import com.icebear2n2.todayhouse.config.exception.ExistAvatarUserException;
import com.icebear2n2.todayhouse.config.exception.UserNotFoundException;
import com.icebear2n2.todayhouse.domain.entity.Avatar;
import com.icebear2n2.todayhouse.domain.entity.User;
import com.icebear2n2.todayhouse.domain.entity.UserAvatar;
import com.icebear2n2.todayhouse.domain.request.ConnectRequest;
import com.icebear2n2.todayhouse.domain.response.UserAvatarResponse;
import com.icebear2n2.todayhouse.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAvatarService {
    private final UserRepository userRepository;
    private final AvatarRepository avatarRepository;
    private final UserAvatarRepository userAvatarRepository;

    public void connect(ConnectRequest request) {
        User user = userRepository.findById(request.userId()).orElseThrow(UserNotFoundException::new);
        Avatar avatar = avatarRepository.findById(request.avatarId()).orElseThrow(AvatarNotFoundException::new);

        Boolean aBoolean = userAvatarRepository.existsByAvatarOrUser(avatar, user);
        if (!aBoolean) {
            UserAvatar userAvatar = new UserAvatar(null, user, avatar);
            userAvatarRepository.save(userAvatar);
        } else {
            throw new ExistAvatarUserException();
        }
    }


    public Page<UserAvatarResponse> getAll(PageRequest request) {
        Page<UserAvatar> all = userAvatarRepository.findAll(request);
        return all.map(UserAvatarResponse::new);
    }
}
