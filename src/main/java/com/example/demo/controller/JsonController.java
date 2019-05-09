package com.example.demo.controller;

import com.example.demo.dao.TestSqlDao;
import com.example.demo.pojo.User;
import com.example.demo.service.AccountService;
import com.example.demo.service.PurchaseService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class JsonController {

    @Resource
    private TestSqlDao testSqlDao;

    @Resource
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/testSql")
    String testSql() {
        return testSqlDao.testSql() + "";
    }

    @RequestMapping("/testSql2")
    User testSql2() {
        return userService.findUserByUserName("zhangsan");
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

    /**
     * 测试简单事务
     *
     * @param outAccountId
     * @param inAccountId
     * @param money
     * @return
     */
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

    @RequestMapping("/purchase")
    String purchase(Long userId, Long productId, Integer quantity) {
        boolean result = purchaseService.purchaseProduct(userId, productId, quantity);
        if(result){
            return "success";
        }
        return "fail";
    }

}
