package com.fc.Service.impl;

import com.fc.Service.CURDService;
import com.fc.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CURDServiceImpl implements CURDService {

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public Object findKey(String key) {
        return redisUtils.get(key);
    }

    @Override
    public void addKV(String key, String type, Object value) {

        redisUtils.set(key,value);
    }
}
