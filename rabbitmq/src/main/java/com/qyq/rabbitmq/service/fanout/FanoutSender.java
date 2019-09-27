package com.qyq.rabbitmq.service.fanout;

import com.qyq.rabbitmq.config.RabbitMqConfig;
import com.qyq.rabbitmq.pojo.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {

    @Autowired
    AmqpTemplate amqpTemplate;

    public void Sender(){
        User user = new User();
        user.setId(4);
        user.setName("Fanout模式");
        //广播模式
        amqpTemplate.convertAndSend(RabbitMqConfig.FANOUT_EXCHANGE,"",user);
    }
}
