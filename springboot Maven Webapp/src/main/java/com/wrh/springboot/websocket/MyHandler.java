package com.wrh.springboot.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.sun.org.apache.bcel.internal.generic.NEW;

@Component
public class MyHandler extends TextWebSocketHandler{
	 private static final ConcurrentHashMap<String,WebSocketSession> users = new ConcurrentHashMap<String,WebSocketSession>();
	 
	 @Override
	 public void afterConnectionEstablished(WebSocketSession session){
		 
	 }
	
	@Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
		 System.out.println("connect to the websocket success......当前数量:"+users.size());
		 System.out.println(new String(message.asBytes()));
		 users.put(new String(message.asBytes()), session);
    }
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status){
		
		 removeSession(session);
		 System.out.println("当前数量:"+users.size());
	}
	
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception){
		 removeSession(session);
		 System.out.println("the websocket is error");
	}
    
	
	private void removeSession(WebSocketSession session){
		 String sessionid = "";
		 for (Entry<String, WebSocketSession> entry : users.entrySet()) {
	        	WebSocketSession weSession = entry.getValue();
	        	if(weSession.getId().equals(session.getId()))
	        	{
	        		sessionid = entry.getKey();
	        	}
		 }
		 if(!"".equals(sessionid))
		 {
			 users.remove(sessionid);
			 System.out.println("remove the websocket :"+sessionid);
		 }
	}
	
	
    /**
     * 给指定用户发送消息
     *
     * @param message
     */
    public void sendMessageToUser(TextMessage message,String sessionid) {
        for (Entry<String, WebSocketSession> entry : users.entrySet()) {
        	WebSocketSession weSession = entry.getValue();
            try {
                if (weSession.isOpen()&&entry.getKey().equals(sessionid)) {
                	weSession.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
