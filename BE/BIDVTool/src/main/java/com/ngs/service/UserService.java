package com.ngs.service;

import com.ngs.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User getById(Integer id);

    User getByUserName(String userName);
}
