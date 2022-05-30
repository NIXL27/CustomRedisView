package com.fc.Service;

import com.fc.entity.User;

public interface UserService {
    public User find(String username, String password);
}
