package com.nyu.IntrotoJava.finalProject.OneRoomChatApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//lombok to skip the boilerplate code

/***
 * UserDTO class, used to transfer user data and hide sensitive information like password
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private String userName;
    private String fullName;
}
