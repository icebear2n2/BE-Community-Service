package com.icebear2n2.todayhouse.houseTourLike.controller;

import com.icebear2n2.todayhouse.domain.request.HouseTourLikeRequest;
import com.icebear2n2.todayhouse.domain.response.HouseTourLikeResponse;
import com.icebear2n2.todayhouse.houseTourLike.service.HouseTourLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/like/house-tour")
public class HouseTourLikeController {
    private final HouseTourLikeService houseTourLikeService;

    @PostMapping
    public void insert(@RequestBody HouseTourLikeRequest request) {
        houseTourLikeService.insert(request);
    }

    @GetMapping
    public Page<HouseTourLikeResponse> getAll(
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return houseTourLikeService.getAll(pageRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long houseTourLikeId) {
        houseTourLikeService.delete(houseTourLikeId);
    }
}
