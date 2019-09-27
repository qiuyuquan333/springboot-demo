package com.qyq.websocket.service;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * websocket实现类
 */
@ServerEndpoint("/websocket/{name}")//此注解标明是websocket服务端，并配置路径
@Component
public class MyWebSocket {

    //存储websocket连接
    private static CopyOnWriteArraySet<MyWebSocket> webSockets = new CopyOnWriteArraySet<>();

    //根据name名称存储session，指定客户端
    private static Map<String,Session> map = new LinkedHashMap<>();

    private Session session;

    private String name;

    /**
     * 连接成功时执行
     * @param name
     * @param session
     */
    @OnOpen
    public void onOpen(@PathParam("name") String name, Session session){
        this.name = name;
        this.session = session;
        //根据name添加session
        map.put(name,session);
        //添加一个连接
        webSockets.add(this);
        System.out.println("有新连接加入！当前在线人数为："+webSockets.size());
        //异步发送消息
        this.session.getAsyncRemote().sendText("恭喜【"+name+"】成功连接上websocket--》当前在线人数为："+webSockets.size());
    }

    /**
     * 连接关闭时执行
     */
    @OnClose
    public void onClose(){
        //移除一个连接
        webSockets.remove(this);
        System.out.println("【"+name+"】断开连接！当前连接人数为："+webSockets.size());
    }

    /**
     * 接收到【客户端】消息时执行
     * @param message
     */
    @OnMessage
    public void onMessage(String message){
        System.out.println("来自【"+name+"】的消息："+message);
        FromSendTo fromSendTo = JSON.parseObject(message, FromSendTo.class);

        Session session = map.get(fromSendTo.getSendTo());//获取接收消息方
        session.getAsyncRemote().sendText(fromSendTo.getMessage());//消息

    }

    /**
     * 异常时执行
     * @param throwable
     */
    @OnError
    public void onError(Throwable throwable){
        System.out.println("发生错误");
        throwable.printStackTrace();
    }

    /**
     * 服务端向指定名称的客户端发送消息
     * @param message
     * @param name
     */
    public void sendMessageByName(String message,String name){
        Session session = map.get(name);
        session.getAsyncRemote().sendText(message);
    }

    /**
     * 服务端向所有客户端发送消息，待优化
     * @param message
     */
    public void sendMessage(String message){
        for (MyWebSocket webSocket : webSockets) {
            webSocket.session.getAsyncRemote().sendText(message);
        }
    }

}
