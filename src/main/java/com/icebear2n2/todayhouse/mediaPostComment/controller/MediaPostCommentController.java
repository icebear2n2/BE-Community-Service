package com.icebear2n2.todayhouse.mediaPostComment.controller;

import com.icebear2n2.todayhouse.domain.request.MediaPostCommentRequest;
import com.icebear2n2.todayhouse.domain.response.MediaPostCommentResponse;
import com.icebear2n2.todayhouse.mediaPostComment.service.MediaPostCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comments/media-post")
public class MediaPostCommentController {

    private final MediaPostCommentService mediaPostCommentService;

    @PostMapping
    public void insert(@RequestBody MediaPostCommentRequest request) {
        mediaPostCommentService.insert(request);
    }

    @GetMapping
    public Page<MediaPostCommentResponse> getAll(
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return mediaPostCommentService.getAll(pageRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long mediaPostCommentId) {
        mediaPostCommentService.delete(mediaPostCommentId);
    }
}
