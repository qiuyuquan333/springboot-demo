package com.qyq.rabbitmq.service.topic;

import com.qyq.rabbitmq.config.RabbitMqConfig;
import com.qyq.rabbitmq.pojo.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void Sender(){
        User user1 = new User();
        user1.setId(2);
        user1.setName("李四");

        User user2 = new User();
        user2.setId(3);
        user2.setName("王五");
        /**
         * 第一个参数：交换器名称
         * 第二个参数：路由键。作用：绑定键和路由键进行匹配成功后指定消息要发送到的队列
         * 第三个参数：消息
         */
        amqpTemplate.convertAndSend(RabbitMqConfig.TOPIC_EXCHANGE,"qyq.message",user1);
        amqpTemplate.convertAndSend(RabbitMqConfig.TOPIC_EXCHANGE,"qyq.yxy",user2);
    }
}
