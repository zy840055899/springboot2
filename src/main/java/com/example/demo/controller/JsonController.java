package com.example.demo.controller;

import com.example.demo.dao.TestSqlDao;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class JsonController {

    @Resource
    private TestSqlDao testSqlDao;

    @Autowired
    private AccountService accountService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/testSql")
    String home() {
        return testSqlDao.testSql() + "";
    }

    /**
     * redis测试 2019-4-24 11:29:39
     *
     * @return
     */
    @RequestMapping("/testRedis")
    String testRedis() {
        stringRedisTemplate.opsForValue().set("k5", "Springboot redis");
        return stringRedisTemplate.opsForValue().get("k5");
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
