package com.icebear2n2.todayhouse.user.service;

import com.icebear2n2.todayhouse.config.exception.ExistEmailException;
import com.icebear2n2.todayhouse.config.exception.UserNotFoundException;
import com.icebear2n2.todayhouse.domain.entity.User;
import com.icebear2n2.todayhouse.domain.request.SignupRequest;
import com.icebear2n2.todayhouse.domain.request.UpdateRequest;
import com.icebear2n2.todayhouse.domain.response.UserResponse;
import com.icebear2n2.todayhouse.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

//    TODO: USER CRUD

    //    TODO: USER CREATE
    public void insert(SignupRequest request) {
        User user = request.toEntity();
        Optional<User> byEmail = userRepository.findByEmail(user.getEmail());
        if (!byEmail.isPresent()) {
            userRepository.save(user);
        } else {
            throw new ExistEmailException();
        }

    }

    //    TODO: USER READ
    public Page<UserResponse> getAll(PageRequest request) {
        Page<User> all = userRepository.findAll(request);
        return all.map(UserResponse::new);
    }

    //    TODO: USER UPDATE
    public UserResponse update(Long userId, UpdateRequest request) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        user.UpdateUser(request.password(), request.username(), request.birth());

        userRepository.save(user);
        return new UserResponse(user);
    }

    //    TODO: USER DELETE -> AVATAR도 같이 DROP
    public void delete(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        userRepository.deleteById(user.getUserId());
    }
}
