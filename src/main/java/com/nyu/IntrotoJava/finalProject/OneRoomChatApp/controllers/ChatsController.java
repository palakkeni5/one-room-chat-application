package com.nyu.IntrotoJava.finalProject.OneRoomChatApp.controllers;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nyu.IntrotoJava.finalProject.OneRoomChatApp.models.Chats;
import com.nyu.IntrotoJava.finalProject.OneRoomChatApp.services.ChatServiceImpl;


@RestController
@RequestMapping("/chats")
public class ChatsController {
	
	@Autowired
	ChatServiceImpl chatService;
	
	@GetMapping(path = "" , produces=MediaType.APPLICATION_JSON_VALUE)
	public Object findAllUser() {
		List<Chats> allChats = chatService.findAllChats();
		
		return allChats;
	}

}
