package com.ngs.service.impl;

import com.ngs.entity.User;
import com.ngs.repository.UserRepository;
import com.ngs.service.UserService;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAll() {
        Iterable<User> users = userRepository.findAll();
        return IterableUtils.toList(users);
    }

    @Override
    public User getById(Integer id) {
        Optional<com.ngs.entity.User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    @Override
    public User getByUserName(String userName) {
        return null;
    }
}
