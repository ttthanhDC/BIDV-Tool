package com.ngs.service;

import com.ngs.entity.User;

import java.util.Set;

public interface UserService {

    Set<User> getAll();

    User getById(Integer id);

    User getByUserName(String userName);
}
