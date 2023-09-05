package com.icebear2n2.todayhouse.follow.controller;

import com.icebear2n2.todayhouse.domain.request.FollowRequest;
import com.icebear2n2.todayhouse.domain.response.FollowResponse;
import com.icebear2n2.todayhouse.follow.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/follow")
public class FollowController {

    private final FollowService followService;

    @PostMapping("add")
    public void addFollow(@RequestBody FollowRequest request) {
        followService.addFollow(request);
    }

    @DeleteMapping("delete")
    public void removeFollow(@RequestBody FollowRequest request) {
        followService.removeFollow(request);
    }

    @GetMapping
    public Page<FollowResponse> getAll(
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return followService.getAll(pageRequest);
    }
}
