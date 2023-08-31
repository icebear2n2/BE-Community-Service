package com.icebear2n2.todayhouse.tipPost.controller;

import com.icebear2n2.todayhouse.domain.request.TipPostRequest;
import com.icebear2n2.todayhouse.domain.response.TipPostResponse;
import com.icebear2n2.todayhouse.tipPost.service.TipPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/post/tip-post")
public class TipPostController {
    private final TipPostService tipPostService;

    @PostMapping
    public void insert(@RequestBody TipPostRequest request) {
        tipPostService.insert(request);
    }

    @GetMapping
    public Page<TipPostResponse> getAll(
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return tipPostService.getAll(pageRequest);
    }

    @PutMapping("{id}")
    public TipPostResponse update(@PathVariable("id") Long tipPostId, @RequestBody TipPostRequest request) {
        return tipPostService.update(tipPostId, request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long tipPostId) {
        tipPostService.delete(tipPostId);
    }
}
