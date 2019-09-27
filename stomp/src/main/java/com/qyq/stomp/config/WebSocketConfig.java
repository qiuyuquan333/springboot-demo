package com.qyq.stomp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker   //开启支持STOMP协议，支持@messageMapping注解
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * 配置服务端地址
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/ws/endpoint").withSockJS();
        registry.addEndpoint("/ws/endpoint").withSockJS();
    }

    /**
     * 配置发送方、广播（订阅）地址
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //设定订阅名称地址前缀(群聊、单聊)
        registry.enableSimpleBroker("/topic","/queue");
        //设定发送方地址前缀
        registry.setApplicationDestinationPrefixes("/app");
    }
}
