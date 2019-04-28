package com.example.demo.service.impl;

import com.example.demo.service.PurchaseService;
import com.example.demo.service.ScheduleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    Logger logger = LoggerFactory.getLogger(PurchaseService.class);

    int count1 = 1;
    int count2 = 1;

    @Scheduled(initialDelay = 3000, fixedRate = 2000)           // 延迟3秒后每2秒执行一次
    @Async                                                      // 支持异步
    public void job1() {
//        logger.info("线程：" + Thread.currentThread().getName() + "job1执行第" + count1++ + "次");
    }

    @Scheduled(cron = "0/3 * * * * ?")                          // 每三秒执行一次
    @Async
    public void job2() {
//        logger.info("线程：" + Thread.currentThread().getName() + "job2执行第" + count2++ + "次");
    }
}
