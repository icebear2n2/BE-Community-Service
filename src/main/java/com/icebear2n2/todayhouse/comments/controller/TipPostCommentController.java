package com.icebear2n2.todayhouse.comments.controller;

import com.icebear2n2.todayhouse.domain.request.TipPostCommentRequest;
import com.icebear2n2.todayhouse.domain.response.TipPostCommentResponse;
import com.icebear2n2.todayhouse.comments.service.TipPostCommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comments/tip-post")
@Tag(name = "Tip Post Comment REST API", description = "노하우 게시물 댓글 REST API")
public class TipPostCommentController {
    private final TipPostCommentService tipPostCommentService;

    @PostMapping
    @Operation(summary = "노하우 게시물 댓글 작성", description = "노하우 게시물에 댓글을 작성할 수 있는 메서드 입니다.")
    public void insert(@RequestBody TipPostCommentRequest request) {
        tipPostCommentService.insert(request);
    }

    @GetMapping
    @Operation(summary = "노하우 게시물 댓글 전체 조회", description = "노하우 게시물에 대한 전체 댓글을 조회할 수 있는 메서드 입니다.")
    public Page<TipPostCommentResponse> getAll(
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return tipPostCommentService.getAll(pageRequest);
    }

    @PutMapping("{id}")
    @Operation(summary = "노하우 게시물 댓글 수정", description = "노하우 게시물에 댓글을 수정할 수 있는 메서드 입니다.")
    public TipPostCommentResponse update(@PathVariable("id") Long tipPostCommentId, @RequestBody TipPostCommentRequest request) {
        return tipPostCommentService.update(tipPostCommentId, request);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "노하우 게시물 댓글 삭제", description = "노하우 게시물에 댓글을 삭제할 수 있는 메서드 입니다.")
    public void delete(@PathVariable("id") Long tipPostCommentId) {
        tipPostCommentService.delete(tipPostCommentId);
    }
}
