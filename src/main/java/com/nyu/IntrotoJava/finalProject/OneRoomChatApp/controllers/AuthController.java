package com.nyu.IntrotoJava.finalProject.OneRoomChatApp.controllers;

import com.nyu.IntrotoJava.finalProject.OneRoomChatApp.models.Users;
import com.nyu.IntrotoJava.finalProject.OneRoomChatApp.services.UsersService;
import com.nyu.IntrotoJava.finalProject.OneRoomChatApp.util.JwtUtils;
import com.nyu.IntrotoJava.finalProject.OneRoomChatApp.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/signup")
    public Result signup(@RequestBody Users user) {
        log.info("username: " + user);

        Users u = usersService.login(user);

        if(u != null){
            return Result.error("username already exists");
        }
        usersService.addUser(user);
        return Result.success();
    }
    @PostMapping("/login")
    public Result login(@RequestBody Users user) {
        log.info("username: " + user);

        Users u = usersService.login(user);

        if(u != null){
//            generate token for the user
            Map<String, Object> claims = new HashMap<>();
            claims.put("userId", u.getUserId());
            claims.put("username", u.getUsername());
            claims.put("fullName", u.getFullName());
            String token = JwtUtils.generateToken(claims);

            return Result.success(token);
        }
        return Result.error("login failed, wrong username or password");
    }
}
