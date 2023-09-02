package com.icebear2n2.todayhouse.tipPostComment.controller;

import com.icebear2n2.todayhouse.domain.request.TipPostCommentRequest;
import com.icebear2n2.todayhouse.domain.response.TipPostCommentResponse;
import com.icebear2n2.todayhouse.tipPostComment.service.TipPostCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comments/tip-post")
public class TipPostCommentController {
    private final TipPostCommentService tipPostCommentService;

    @PostMapping
    public void insert(@RequestBody TipPostCommentRequest request) {
        tipPostCommentService.insert(request);
    }

    @GetMapping
    public Page<TipPostCommentResponse> getAll(
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return tipPostCommentService.getAll(pageRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long tipPostCommentId) {
        tipPostCommentService.delete(tipPostCommentId);
    }
}
