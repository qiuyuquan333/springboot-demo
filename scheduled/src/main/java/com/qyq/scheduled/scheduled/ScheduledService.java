package com.qyq.scheduled.scheduled;

import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

/**
 * spring自带的定时任务
 */
//@Component
public class ScheduledService {

    @Scheduled(fixedRate = 3000)
    public void fixedRate(){
        System.out.println("两次任务开始执行间隔 ：fixedRate："+new Date());
    }

    @Scheduled(fixedDelay = 5000)
    public void fixedDelay(){
        System.out.println("本次任务结束到下次任务开始时间间隔 ：fixedDelay："+new Date());
    }

    @Scheduled(initialDelay = 2000,fixedDelay = 2000)
    public void initialDelay(){
        System.out.println("首次任务执行 ：initialDelay："+new Date());
    }

    @Scheduled(cron = "0/5 * * * * *")
    public void cron(){
        System.out.println("这是cron表达式："+new Date());
    }
}
