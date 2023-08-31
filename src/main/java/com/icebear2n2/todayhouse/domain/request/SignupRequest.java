package com.icebear2n2.todayhouse.domain.request;

import com.icebear2n2.todayhouse.domain.entity.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record SignupRequest(String email, String password, String username, LocalDate birth) {
    public User toEntity() {
        return User.builder().email(email).password(password).userName(username).birth(birth).build();
    }
}
