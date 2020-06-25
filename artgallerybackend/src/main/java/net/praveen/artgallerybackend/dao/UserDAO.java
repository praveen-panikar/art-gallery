package net.praveen.artgallerybackend.dao;

import net.praveen.artgallerybackend.dto.Cart;
import net.praveen.artgallerybackend.dto.User;

public interface UserDAO {
	
	//add an user
	boolean addUser(User user);
	
	User getByEmail(String email);
	
	

}
