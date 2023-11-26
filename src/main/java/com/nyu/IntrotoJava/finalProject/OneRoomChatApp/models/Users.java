package com.nyu.IntrotoJava.finalProject.OneRoomChatApp.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "USERS")
public class Users {

    
	@Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name="username", nullable = false)
    private String username;

    @Column(name="user_fullname", nullable = false)
    private String fullName;

    @Column(name="date_created",nullable = false )
    private Date dateCreated;

    public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", username=" + username + ", fullName=" + fullName + ", dateCreated="
				+ dateCreated + "]";
	}

}
