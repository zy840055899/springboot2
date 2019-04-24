package com.example.demo.service.impl;

import com.example.demo.pojo.User;
import com.example.demo.service.TestService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Override
    @Cacheable("users")             // 开启缓存
    public User getSingleUser(Long id) {
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            throw new IllegalStateException();
        }
        return new User(id, "user" + id);
    }
}
