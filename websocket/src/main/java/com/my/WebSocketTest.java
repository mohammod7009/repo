package com.my;

import java.io.IOException;
 
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
 
@ServerEndpoint("/wstest") 
public class WebSocketTest {

	@OnOpen
	public void onOpen(Session session) {
		System.out.println("Connection opended by "+ session.getId());
		try {
		session.getBasicRemote().sendText("Connection opended by "+ session.getId());
		} catch (IOException ex) {
            ex.printStackTrace();			
		}
	}

	@OnMessage
    public void onMessage(String message, Session session){
		System.out.println(message+" received from " + session.getId());
        try {
            session.getBasicRemote().sendText(message+" response from server");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    @OnClose
    public void onClose(Session session){
        System.out.println("Connection closed by " +session.getId());
    }
}