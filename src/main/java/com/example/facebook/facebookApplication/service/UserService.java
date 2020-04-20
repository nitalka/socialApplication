package com.example.facebook.facebookApplication.service;

import com.example.facebook.facebookApplication.repository.UserRepository;
import com.example.facebook.facebookApplication.utils.TransformationUtils;
import com.example.facebook.facebookApplication.models.UserRequest;
import com.example.facebook.facebookApplication.models.UserResponse;
import com.example.facebook.facebookApplication.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserResponse save(UserRequest userRequest) {

        User user= TransformationUtils.toDao(userRequest);
        return TransformationUtils.toDto(userRepository.save(user));

    }

    public List<User> findAll() {
        return  userRepository.findAll();
    }

}
