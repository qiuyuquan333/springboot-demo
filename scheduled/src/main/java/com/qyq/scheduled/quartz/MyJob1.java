package com.qyq.scheduled.quartz;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 无法传参
 */
@Component
public class MyJob1 {

    public void sayHello(){
        System.out.println("Hello !this is my job1 "+new Date());
    }
}
