package com.qyq.stomp.controller;

import com.qyq.stomp.pojo.MessageSendTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

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
     * 点对点单聊。。。。。。。。没成功，另外一方接收不到消息，（无法指定己方标识），后续解决
     * @param sendTo
     */
    @MessageMapping("/sendTo")
    public void messageSendTo(@RequestBody MessageSendTo sendTo){
        System.out.println(sendTo.toString());
        messagingTemplate.convertAndSendToUser(sendTo.getSendTo(),"/queue/aloneResponse",sendTo.getMessage());
    }

}
