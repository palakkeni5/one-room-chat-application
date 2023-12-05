package com.nyu.IntrotoJava.finalProject.OneRoomChatApp.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import com.nyu.IntrotoJava.finalProject.OneRoomChatApp.request.ChatFromClientRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = { "*" })
@Controller
public class ChatsSocketController {
	
	 // Handles messages from /app/chat.
	@MessageMapping("/chat")
	// Sends the return value of this method to /topic/messages
	@SendTo("/topic/messages")
	public ChatFromClientRequest getMesssage(@RequestBody ChatFromClientRequest m) {
		log.info(m.toString());
		return m;
	}
}
