package com.ydh.redsheep.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: yangdehong
 * @version: 2017/10/25.
 */
@Component
public class WebSocketHandler extends TextWebSocketHandler {

    // 保存所有的用户session
    private static final List<WebSocketSession> sessions = new ArrayList<>();

    // 连接 就绪时
    @Override
    public void afterConnectionEstablished(WebSocketSession session)
            throws Exception {

        System.out.println("客户端地址 连接===="+session.getRemoteAddress());
        sessions.add(session);
    }

    // 处理信息
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {

        System.out.println("receive message==="+message.getPayload());
        // 处理消息 msgContent消息内容
        TextMessage textMessage = new TextMessage(message.getPayload()+"", true);
        // 调用方法（发送消息给所有人）
        sendMsgToAllUsers(textMessage);

    }

    // 关闭 连接时
    @Override
    public void afterConnectionClosed(WebSocketSession session,
                                      CloseStatus closeStatus) throws Exception {
        System.out.println("客户端地址 关闭===="+session.getRemoteAddress());
        sessions.remove(session);
    }

    // 处理传输时异常
    @Override
    public void handleTransportError(WebSocketSession session,
                                     Throwable exception) throws Exception {
        System.out.println("异常===="+exception.getMessage());
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    // 给所有用户发送 信息
    public void sendMsgToAllUsers(WebSocketMessage<?> message) throws Exception{

        for (WebSocketSession session : sessions) {
            session.sendMessage(message);
        }

    }
}
