package com.example.demo.service;

import com.example.demo.pojo.Result;

public interface LoginService {
    Result login(String userName, String password);
    void logout();
}
