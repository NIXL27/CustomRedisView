package com.fc.dao;

import com.fc.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User find(@Param("username") String username,@Param("password") String password);
}
