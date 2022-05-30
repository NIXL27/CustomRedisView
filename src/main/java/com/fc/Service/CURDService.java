package com.fc.Service;

public interface CURDService {
    Object findKey(String key);

    void addKV(String key, String type, Object value);
}
