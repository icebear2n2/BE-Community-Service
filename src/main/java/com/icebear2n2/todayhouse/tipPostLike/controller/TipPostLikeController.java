package com.icebear2n2.todayhouse.tipPostLike.controller;

import com.icebear2n2.todayhouse.domain.request.TipPostLikeRequest;
import com.icebear2n2.todayhouse.domain.response.TipPostLikeResponse;
import com.icebear2n2.todayhouse.domain.response.TipPostResponse;
import com.icebear2n2.todayhouse.tipPostLike.service.TipPostLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/like/tip-post")
public class TipPostLikeController {
    private final TipPostLikeService tipPostLikeService;

    @PostMapping
    public void insert(@RequestBody TipPostLikeRequest request) {
        tipPostLikeService.insert(request);
    }

    @GetMapping
    public Page<TipPostLikeResponse> getAll(
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return tipPostLikeService.getAll(pageRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long tipPostLikeId) {
        tipPostLikeService.delete(tipPostLikeId);
    }
}
