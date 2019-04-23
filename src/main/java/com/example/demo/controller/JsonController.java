package com.example.demo.controller;

import com.example.demo.dao.TestSqlDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class JsonController {

    @Resource
    private TestSqlDao testSqlDao;

    @RequestMapping("/testSql")
    String home() {
        return testSqlDao.testSql() + "";
    }

}
