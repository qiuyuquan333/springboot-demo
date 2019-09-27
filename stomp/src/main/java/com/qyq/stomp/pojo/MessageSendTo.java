package com.qyq.stomp.pojo;

public class MessageSendTo {

    private String sendFrom;

    private String sendTo;

    private String message;

    public String getSendFrom() {
        return sendFrom;
    }

    public void setSendFrom(String sendFrom) {
        this.sendFrom = sendFrom;
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

    @Override
    public String toString() {
        return "MessageSendTo{" +
                "sendFrom='" + sendFrom + '\'' +
                ", sendTo='" + sendTo + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
