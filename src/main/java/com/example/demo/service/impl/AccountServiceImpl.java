package com.example.demo.service.impl;

import com.example.demo.dao.TestSqlDao;
import com.example.demo.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private TestSqlDao testSqlDao;

    @Transactional /*简单事务的应用*/
    @Override
    public void transferMoney(String outAccountId, String inAccountId, BigDecimal money) {
        testSqlDao.minusMoney(outAccountId, money);
//        int a = 1/0;
        testSqlDao.addMoney(inAccountId, money);
    }
}
