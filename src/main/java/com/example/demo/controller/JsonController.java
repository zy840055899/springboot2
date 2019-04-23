package com.example.demo.controller;

import com.example.demo.dao.TestSqlDao;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
public class JsonController {

    @Resource
    private TestSqlDao testSqlDao;

    @Autowired
    private AccountService accountService;

    @RequestMapping("/testSql")
    String home() {
        return testSqlDao.testSql() + "";
    }

    @RequestMapping("/transferMoney")
    String transferMoney(String outAccountId, String inAccountId, String money) {
        try {
            accountService.transferMoney(outAccountId, inAccountId, money);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }


}
