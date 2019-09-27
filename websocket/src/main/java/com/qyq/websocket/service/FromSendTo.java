package com.qyq.websocket.service;

/**
 * 发送请求实体类
 */
public class FromSendTo {

    //消息类型，群聊还是单聊
    private Integer type;

    //消息发送方
    private String fromSend;

    //消息接收方
    private String sendTo;

    //消息
    private String message;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getFromSend() {
        return fromSend;
    }

    public void setFromSend(String fromSend) {
        this.fromSend = fromSend;
    }

    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
