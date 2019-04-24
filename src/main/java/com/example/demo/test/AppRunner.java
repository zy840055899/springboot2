package com.example.demo.test;

import com.example.demo.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 程序启动后运行
 */
@Component
//@Order(value = 2) 执行顺序
public class AppRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final TestService testService;

    public AppRunner(TestService testService) {
        this.testService = testService;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info(".... Fetching users");
        logger.info("user-1 -->" + testService.getSingleUser(1l));
        logger.info("user-2 -->" + testService.getSingleUser(2l));
        logger.info("user-1 -->" + testService.getSingleUser(1l));
        logger.info("user-4 -->" + testService.getSingleUser(4l));
    }

}
