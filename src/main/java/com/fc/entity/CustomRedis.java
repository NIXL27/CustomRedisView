package com.fc.entity;

import lombok.Data;

@Data
public class CustomRedis {
    public String host;
    public Integer port;
    public String username;
    public String password;
}
