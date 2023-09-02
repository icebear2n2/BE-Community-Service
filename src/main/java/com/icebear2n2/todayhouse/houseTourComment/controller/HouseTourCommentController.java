package com.icebear2n2.todayhouse.houseTourComment.controller;

import com.icebear2n2.todayhouse.domain.request.HouseTourCommentRequest;
import com.icebear2n2.todayhouse.domain.response.HouseTourCommentResponse;
import com.icebear2n2.todayhouse.houseTourComment.service.HouseTourCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comments/house-tour")
public class HouseTourCommentController {
    private final HouseTourCommentService houseTourCommentService;

    @PostMapping
    public void insert(@RequestBody HouseTourCommentRequest request) {
        houseTourCommentService.insert(request);
    }

    @GetMapping
    public Page<HouseTourCommentResponse> getAll(
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);

        return houseTourCommentService.getAll(pageRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long houseTourCommentId) {
        houseTourCommentService.delete(houseTourCommentId);
    }
}
