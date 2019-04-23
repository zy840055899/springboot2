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
            BigDecimal bigDecimal = BigDecimal.valueOf(Double.parseDouble(money));
            // 精确到0.01，其余位直接删除
            BigDecimal result = bigDecimal.setScale(2, BigDecimal.ROUND_DOWN);

            accountService.transferMoney(outAccountId, inAccountId, result);

            return "success";

        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }


}
