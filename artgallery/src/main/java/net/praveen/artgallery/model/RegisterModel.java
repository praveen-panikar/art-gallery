package net.praveen.artgallery.model;

import java.io.Serializable;

import net.praveen.artgallerybackend.dto.User;

public class RegisterModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
