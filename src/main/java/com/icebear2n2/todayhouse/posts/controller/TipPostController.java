package com.icebear2n2.todayhouse.posts.controller;

import com.icebear2n2.todayhouse.domain.request.TipPostRequest;
import com.icebear2n2.todayhouse.domain.response.TipPostResponse;
import com.icebear2n2.todayhouse.posts.service.TipPostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts/tip-post")
@Tag(name = "Tip Post REST API", description = "노하우 게시물 REST API")
public class TipPostController {
    private final TipPostService tipPostService;

    @PostMapping
    @Operation(summary = "노하우 게시물 작성", description = "노하우 게시물에 대한 정보를 작성할 수 있는 메서드 입니다.")
    public void insert(@RequestBody TipPostRequest request) {
        tipPostService.insert(request);
    }

    @GetMapping
    @Operation(summary = "노하우 게시물 전체 조회", description = "노하우 게시물에 대한 전체 정보를 조회할 수 있는 메서드 입니다.")
    public Page<TipPostResponse> getAll(
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return tipPostService.getAll(pageRequest);
    }

    @PutMapping("{id}")
    @Operation(summary = "노하우 게시물 수정", description = "노하우 게시물에 대한 정보를 수정할 수 있는 메서드 입니다.")
    public TipPostResponse update(@PathVariable("id") Long tipPostId, @RequestBody TipPostRequest request) {
        return tipPostService.update(tipPostId, request);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "노하우 게시물 삭제", description = "노하우 게시물에 대한 정보를 삭제할 수 있는 메서드 입니다.")
    public void delete(@PathVariable("id") Long tipPostId) {
        tipPostService.delete(tipPostId);
    }
}
