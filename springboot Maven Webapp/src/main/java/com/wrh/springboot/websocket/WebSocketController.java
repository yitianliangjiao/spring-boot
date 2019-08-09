package com.wrh.springboot.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;

@RestController
@RequestMapping("/websocket")
public class WebSocketController {
	
	@Autowired
	MyHandler myHandler;

	@RequestMapping("/index")
	String home(String bdcode) {
		System.out.println("555");
		return "websocket";
	}
	
	@RequestMapping("/send")
	public String SendMsg(String msg,String sessionid){
		myHandler.sendMessageToUser(new TextMessage(msg.getBytes()),sessionid);
		return msg;
	}

}
