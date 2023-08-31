package com.icebear2n2.todayhouse.mediaPost.controller;

import com.icebear2n2.todayhouse.domain.request.MediaPostRequest;
import com.icebear2n2.todayhouse.domain.response.MediaPostResponse;
import com.icebear2n2.todayhouse.mediaPost.service.MediaPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/post/media-post")
public class MediaPostController {

    private final MediaPostService mediaPostService;

    @PostMapping
    public void insert(@RequestBody MediaPostRequest request) {
        mediaPostService.insert(request);
    }

    @GetMapping
    public Page<MediaPostResponse> getAll(
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);

        return mediaPostService.getAll(pageRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long mediaPostId) {
        mediaPostService.delete(mediaPostId);
    }
}
