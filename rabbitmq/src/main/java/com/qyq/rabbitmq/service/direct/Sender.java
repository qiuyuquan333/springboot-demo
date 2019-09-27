package com.qyq.rabbitmq.service.direct;

import com.qyq.rabbitmq.config.RabbitMqConfig;
import com.qyq.rabbitmq.pojo.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendDirectQueue(){
        User user = new User();
        user.setId(1);
        user.setName("张三");
        //参数1：指定发送消息到那个队列。参数2：消息
        amqpTemplate.convertAndSend(RabbitMqConfig.QUEUE,user);
        System.out.println("DirectQueue队列已发送消息");
    }
}
