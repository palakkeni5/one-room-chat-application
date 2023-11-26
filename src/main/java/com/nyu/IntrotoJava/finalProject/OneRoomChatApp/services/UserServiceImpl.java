package com.nyu.IntrotoJava.finalProject.OneRoomChatApp.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nyu.IntrotoJava.finalProject.OneRoomChatApp.dao.UsersRepository;
import com.nyu.IntrotoJava.finalProject.OneRoomChatApp.models.Users;

@Service
public class UserServiceImpl implements UsersService {

	@Autowired
	UsersRepository usersRepository;

	@Override
	public Optional<Users> findUserById(long id) {
		// TODO Auto-generated method stub
		Optional<Users> user = usersRepository.findById(id);
		if (user.isEmpty()) {
			return Optional.empty();
		}
		else return user;
	}

	@Override
	public List<Users> findAllUsers() {
		return (List<Users>) usersRepository.findAll();
	}

	@Override
	public void addUser(String userName, String FullName) {
		Users newUser = new Users();
		newUser.setUsername(userName);
		newUser.setFullName(FullName);
		usersRepository.save(newUser);		
	}
}
