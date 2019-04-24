package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching// 开启缓存
//mapper接口的路径,不加也可以，dao上加上@mapper注解，加上的话可以用@repository注解，注入时候可以使用@Autowired
//@MapperScan(basePackages = "com.example.demo.dao")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
