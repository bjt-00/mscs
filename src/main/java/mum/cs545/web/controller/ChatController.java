package mum.cs545.web.controller;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Singleton;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/chat")
@Singleton
public class ChatController {

	Set<Session> userSessions = Collections.synchronizedSet(new HashSet<Session>());
	@OnOpen
	public void onOpen(Session userSession) {
	System.out.println("New request received. Id: " + userSession.getId());
	userSessions.add(userSession);
	} @
	OnClose
	public void onClose(Session userSession) {
	System.out.println("Connection closed. Id: " + userSession.getId());
	userSessions.remove(userSession);
	} @
	OnMessage
	public void onMessage(String message, Session userSession) {
	System.out.println("Message Received: " + message);
	for (Session session : userSessions) {
	System.out.println("Sending to " + session.getId());
	session.getAsyncRemote().sendText(message);
	}
	}
	
}
