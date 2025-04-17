package com.hw.service;

import com.hw.model.dto.User;
import com.hw.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
    public void saveUser(User user) {
        userRepository.saveUser(user);
    }
}
