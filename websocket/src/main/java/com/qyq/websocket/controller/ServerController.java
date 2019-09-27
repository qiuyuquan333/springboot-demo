package com.qyq.websocket.controller;

import com.qyq.websocket.service.MyWebSocket;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务端发送消息
 */
@RestController
public class ServerController {

    MyWebSocket myWebSocket = new MyWebSocket();

    /**
     * 服务端向所有客户端发送消息
     * @param message 消息
     */
    @RequestMapping("/fozu/{message}")
    public void FoController(@PathVariable("message") String message){
        myWebSocket.sendMessage(message);
    }

    /**
     * 服务端向指定客户端发送消息
     * @param name 指定客户端的名称
     * @param message 消息
     */
    @RequestMapping("/yudi/{name}/{message}")
    public void YuDiController(@PathVariable("name") String name,@PathVariable("message") String message){
        myWebSocket.sendMessageByName(message,name);
    }
}
