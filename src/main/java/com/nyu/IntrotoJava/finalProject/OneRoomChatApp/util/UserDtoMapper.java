package com.nyu.IntrotoJava.finalProject.OneRoomChatApp.util;

import com.nyu.IntrotoJava.finalProject.OneRoomChatApp.dto.UserDTO;
import com.nyu.IntrotoJava.finalProject.OneRoomChatApp.models.Users;

/***
 * UserDtoMapper class
 * used to map user data to userDTO by using the static method toDTO
 */
public class UserDtoMapper {

    public static UserDTO toDTO(Users user) {
        return new UserDTO(user.getUsername(), user.getFullName());
    }

}
