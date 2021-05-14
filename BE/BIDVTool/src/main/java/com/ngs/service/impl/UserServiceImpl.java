package com.ngs.service.impl;

import com.ngs.entity.User;
import com.ngs.repository.UserRepository;
import com.ngs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }
}
