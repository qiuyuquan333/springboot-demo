package com.qyq.stomp.controller;

import com.qyq.stomp.pojo.MessageSendTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class StompController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    /**
     * 群聊 -- 发送方的消息返回给所有订阅方
     * @param name
     * @return
     * @throws Exception
     */
    //发送者地址
    @MessageMapping("/hello")
    //订阅（广播）地址
    @SendTo("/topic/greetings")
    public String greeting(String name)throws Exception{
        System.out.println(name);
        Thread.sleep(1000);
        return "Hello "+name+" ! ";
    }

    /**
     * 使用SimpMessagingTemplate模板，可以动态指定订阅地址, @sendTo注解不可以
     * @param message
     */
    @MessageMapping("/hello1")
    public void greetings(String message){
        messagingTemplate.convertAndSend("/topic/greetings",message);
    }


    /**
     * 点对点单聊。。。。。。。。需要使用security拦截确定用户身份。
     * @param sendTo
     */
    @MessageMapping("/sendTo")
    public void messageSendTo(MessageSendTo sendTo,Principal principal){
        System.out.println(sendTo.toString());
        System.out.println("Principal："+principal);
        /**
         * 第一个参数：消息接收方
         * 第二个参数：订阅地址
         * 第三个参数：消息
         */
        messagingTemplate.convertAndSendToUser(sendTo.getSendTo(),"/queue/aloneResponse",sendTo.getMessage());
    }

}
