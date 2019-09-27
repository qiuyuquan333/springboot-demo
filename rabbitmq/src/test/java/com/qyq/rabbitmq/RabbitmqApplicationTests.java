package com.qyq.rabbitmq;

import com.qyq.rabbitmq.service.fanout.FanoutSender;
import com.qyq.rabbitmq.service.topic.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {

    @Autowired
    TopicSender topicSender;

    @Autowired
    FanoutSender fanoutSender;

    /**
     * direct模式测试
     */
    @Test
    public void contextLoads() {
        topicSender.Sender();
    }

    /**
     * fanout模式测试
     */
    @Test
    public void FanoutTest(){
        fanoutSender.Sender();
    }




}
