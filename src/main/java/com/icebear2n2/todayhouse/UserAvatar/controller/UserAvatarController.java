package com.icebear2n2.todayhouse.UserAvatar.controller;

import com.icebear2n2.todayhouse.UserAvatar.service.UserAvatarService;
import com.icebear2n2.todayhouse.domain.request.ConnectRequest;
import com.icebear2n2.todayhouse.domain.response.UserAvatarResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/connect")
public class UserAvatarController {

    private final UserAvatarService userAvatarService;

    @PostMapping
    public void connect(@RequestBody ConnectRequest request) {
        userAvatarService.connect(request);
    }

    @GetMapping
    public Page<UserAvatarResponse> getAll(
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page) {
        PageRequest pageRequest = PageRequest.of(page, size);

        return userAvatarService.getAll(pageRequest);
    }
}
