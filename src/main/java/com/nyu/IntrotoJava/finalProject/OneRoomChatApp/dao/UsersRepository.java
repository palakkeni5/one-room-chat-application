package com.nyu.IntrotoJava.finalProject.OneRoomChatApp.dao;


import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nyu.IntrotoJava.finalProject.OneRoomChatApp.models.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
	
//	Users addUser(String userName);
	
}
