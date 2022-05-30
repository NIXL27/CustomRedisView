package com.fc.Service.impl;

import com.fc.Service.UserService;
import com.fc.dao.UserMapper;
import com.fc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User find(String username, String password) {
        return userMapper.find(username, password);
    }
}
