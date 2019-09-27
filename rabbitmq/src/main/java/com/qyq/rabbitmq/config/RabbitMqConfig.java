package com.qyq.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * rabbitMQ配置类
 * direct模式：消息中的路由键（routing key）如果和 Binding 中的 binding key 一致， 交换器就将消息发到对应的队列中。路由键与队列名完全匹配。
 * topic模式：topic交换器的绑定键(binding_key)和路由键(routing_key)完全匹配上才会将消息发到对应的队列中。
 * fanout模式：广播，将消息发送到所有与fanout交换器绑定的队列中国。
 */
@Configuration
public class RabbitMqConfig {

    /**
     * direct模式
     */
    public final static String QUEUE = "direct";
//
//    创建队列
//    @Bean
//    public Queue directQueue(){
//        return new Queue(QUEUE,true);
//    }

    /**
     * topic模式
     */
    public final static String TOPIC_QUEUE1 = "topic.queue1";
    public final static String TOPIC_QUEUE2 = "topic.queue2";
    public final static String TOPIC_EXCHANGE = "topic.exchange";

    @Bean
    public Queue topicQueue1(){
        return new Queue(TOPIC_QUEUE1);
    }

    @Bean
    public Queue topicQueue2(){
        return new Queue(TOPIC_QUEUE2);
    }

//    创建交换器
//    @Bean
//    public TopicExchange topicExchange(){
//        return new TopicExchange(TOPIC_EXCHANGE);
//    }
//
//    路由绑定
//    @Bean
//    public Binding topicBinding1(){
//            队列和交换器绑定并设置绑定键
//        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("qyq.message");
//    }
//
//    路由绑定
//    @Bean
//    public Binding topicBinding2(){
//          队列和交换器绑定并设置绑定键
//        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("qyq.#");
//    }

    /**
     * fanout模式
     */
    public final static String FANOUT_EXCHANGE = "fanout.exchange";

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean
    public Binding fanoutBinding1(){
        //队列和交换器绑定
        return BindingBuilder.bind(topicQueue1()).to(fanoutExchange());
    }

    @Bean
    public Binding fanoutBinding2(){
        //队列和交换器绑定
        return BindingBuilder.bind(topicQueue2()).to(fanoutExchange());
    }

}
