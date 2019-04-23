package com.example.demo.service;

import java.math.BigDecimal;

public interface AccountService {
    void transferMoney(String outAccountId, String inAccountId, BigDecimal money);
}
