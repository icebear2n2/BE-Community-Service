package com.icebear2n2.todayhouse.user.controller;

import com.icebear2n2.todayhouse.domain.request.SignupRequest;
import com.icebear2n2.todayhouse.domain.request.UpdateRequest;
import com.icebear2n2.todayhouse.domain.response.UserResponse;
import com.icebear2n2.todayhouse.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/client")
public class UserController {

    private final UserService userService;

    @PostMapping("signup")
    public void signup(@RequestBody SignupRequest request) {
        userService.insert(request);
    }

    @GetMapping
    public Page<UserResponse> getAll(
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return userService.getAll(pageRequest);
    }

    @PutMapping("{id}")
    public UserResponse update(@PathVariable("id") Long userId, @RequestBody(required = false) UpdateRequest request) {
        return userService.update(userId, request);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") Long userId) {
        userService.delete(userId);
    }
}
