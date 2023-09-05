package com.icebear2n2.todayhouse.comments.controller;

import com.icebear2n2.todayhouse.domain.request.HouseTourCommentRequest;
import com.icebear2n2.todayhouse.domain.response.HouseTourCommentResponse;
import com.icebear2n2.todayhouse.comments.service.HouseTourCommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comments/house-tour")
@Tag(name = "House Tour Comment REST API", description = "집들이 게시물 댓글 REST API")
public class HouseTourCommentController {
    private final HouseTourCommentService houseTourCommentService;

    @PostMapping
    @Operation(summary = "집들이 게시물 댓글 작성", description = "집들이 게시물에 댓글을 작성할 수 있는 메서드 입니다.")
    public void insert(@RequestBody HouseTourCommentRequest request) {
        houseTourCommentService.insert(request);
    }

    @GetMapping
    @Operation(summary = "집들이 게시물 댓글 전체 조회", description = "집들이 게시물에 대한 전체 댓글을 조회할 수 있는 메서드 입니다.")
    public Page<HouseTourCommentResponse> getAll(
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);

        return houseTourCommentService.getAll(pageRequest);
    }

    @PutMapping("{id}")
    @Operation(summary = "집들이 게시물 댓글 수정", description = "집들이 게시물에 댓글을 수정할 수 있는 메서드 입니다.")
    public HouseTourCommentResponse update(@PathVariable("id") Long houseTourCommentId, @RequestBody HouseTourCommentRequest request) {
        return houseTourCommentService.update(houseTourCommentId, request);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "집들이 게시물 댓글 삭제", description = "집들이 게시물에 댓글을 삭제할 수 있는 메서드 입니다.")
    public void delete(@PathVariable("id") Long houseTourCommentId) {
        houseTourCommentService.delete(houseTourCommentId);
    }
}
