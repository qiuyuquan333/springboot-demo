package com.qyq.rabbitmq.controller;

import com.qyq.rabbitmq.service.direct.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DirectController {

    @Autowired
    private Sender sender;

    @RequestMapping("/direct")
    public void Direct(){
        sender.sendDirectQueue();
    }
}
