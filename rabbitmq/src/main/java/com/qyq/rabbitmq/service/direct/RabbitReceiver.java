package com.qyq.rabbitmq.service.direct;

import com.qyq.rabbitmq.config.RabbitMqConfig;
import com.qyq.rabbitmq.pojo.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitReceiver {

    /**
     * @RabbitListener注解 指定监听的队列
     * @param user
     */
    @RabbitListener(queues = RabbitMqConfig.QUEUE)
    public void receiverDirectQueue(User user){
        System.out.println("消费者："+user.toString());
    }
}
