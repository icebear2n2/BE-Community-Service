package com.icebear2n2.todayhouse.follow.service;

import com.icebear2n2.todayhouse.avatar.repository.AvatarRepository;
import com.icebear2n2.todayhouse.domain.entity.Avatar;
import com.icebear2n2.todayhouse.domain.entity.Follow;
import com.icebear2n2.todayhouse.domain.request.FollowRequest;
import com.icebear2n2.todayhouse.domain.response.FollowResponse;
import com.icebear2n2.todayhouse.follow.repository.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FollowService {
    private final FollowRepository followRepository;
    private final AvatarRepository avatarRepository;

    public void addFollow(FollowRequest request) {
        Avatar follower = avatarRepository.findById(request.followerId()).orElseThrow(() -> new RuntimeException("Follower Not Found!"));
        Avatar following = avatarRepository.findById(request.followingId()).orElseThrow(() -> new RuntimeException("Following Not Found!"));
        Boolean existsByFollowerAndFollowing = followRepository.existsByFollowerAndFollowing(follower, following);

        if (!existsByFollowerAndFollowing && !Objects.equals(follower.getAvatarId(), following.getAvatarId())) {
            Follow follow = request.toEntity(follower, following);
            followRepository.save(follow);
        } else {
            throw new RuntimeException("EXIST Follower AND Following.");
        }

    }

    public void removeFollow(FollowRequest request) {
        Avatar follower = avatarRepository.findById(request.followerId()).orElseThrow(() -> new RuntimeException("User Not Found!"));
        Avatar following = avatarRepository.findById(request.followingId()).orElseThrow(() -> new RuntimeException("User Not Found!"));

        Follow follow = followRepository.findByFollowerAndFollowing(follower, following);
        if (follow != null) {
            followRepository.delete(follow);
        } else {
            throw new RuntimeException("Follow relationship not found!");
        }
    }

    public Page<FollowResponse> getAll(PageRequest request) {
        Page<Follow> all = followRepository.findAll(request);
        return all.map(FollowResponse::new);
    }
}
