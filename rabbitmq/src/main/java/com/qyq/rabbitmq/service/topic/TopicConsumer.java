package com.qyq.rabbitmq.service.topic;

import com.qyq.rabbitmq.config.RabbitMqConfig;
import com.qyq.rabbitmq.pojo.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicConsumer {

    @RabbitListener(queues = RabbitMqConfig.TOPIC_QUEUE1)
    public void TopicConsumer1(User user){
        System.out.println("topic模式消费者1："+user.toString());
    }

    @RabbitListener(queues = RabbitMqConfig.TOPIC_QUEUE2)
    public void TopicConsumer2(User user){
        System.out.println("topic模式消费者2："+user.toString());
    }
}
