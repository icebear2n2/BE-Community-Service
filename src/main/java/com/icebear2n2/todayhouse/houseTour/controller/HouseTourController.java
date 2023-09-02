package com.icebear2n2.todayhouse.houseTour.controller;

import com.icebear2n2.todayhouse.domain.dto.HouseTourDto;
import com.icebear2n2.todayhouse.domain.request.HouseTourRequest;
import com.icebear2n2.todayhouse.domain.response.HouseTourResponse;
import com.icebear2n2.todayhouse.houseTour.service.HouseTourService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts/house-tour")
public class HouseTourController {

    private final HouseTourService houseTourService;

    @PostMapping
    public void insert(@RequestBody HouseTourRequest request) {
        houseTourService.insert(request);
    }

    @GetMapping
    public Page<HouseTourResponse> getAll(
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return houseTourService.getAll(pageRequest);
    }

    @PutMapping("{id}")
    public HouseTourResponse update(@PathVariable("id") Long houseTourId, @RequestBody HouseTourRequest request) {
        return houseTourService.update(houseTourId, request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long houseTourId) {
        houseTourService.delete(houseTourId);
    }
}
