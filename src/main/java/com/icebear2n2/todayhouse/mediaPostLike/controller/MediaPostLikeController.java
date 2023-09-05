package com.icebear2n2.todayhouse.mediaPostLike.controller;

import com.icebear2n2.todayhouse.domain.request.MediaPostLikeRequest;
import com.icebear2n2.todayhouse.domain.response.MediaPostLikeResponse;
import com.icebear2n2.todayhouse.mediaPostLike.service.MediaPostLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/like/media-post")
public class MediaPostLikeController {
    private final MediaPostLikeService mediaPostLikeService;

    @PostMapping
    public void insert(@RequestBody MediaPostLikeRequest request) {
        mediaPostLikeService.insert(request);
    }

    @GetMapping
    public Page<MediaPostLikeResponse> getAll(
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return mediaPostLikeService.getAll(pageRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long mediaPostLikeId) {
        mediaPostLikeService.delete(mediaPostLikeId);
    }
}
