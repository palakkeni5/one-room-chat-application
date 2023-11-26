package com.nyu.IntrotoJava.finalProject.OneRoomChatApp.models;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name = "chats")
public class Chats {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="message_id")
    private Long id;

    @Column(name="message_text", nullable=false)
    private String messageText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "fk_users"))
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Users user;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="message_date", nullable=false)
    private Date messageDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Date getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}

	@Override
	public String toString() {
		return "Chats [id=" + id + ", messageText=" + messageText + ", user=" + user + ", messageDate=" + messageDate
				+ "]";
	}
    
    
}
