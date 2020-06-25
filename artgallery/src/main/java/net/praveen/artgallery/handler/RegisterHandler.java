package net.praveen.artgallery.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import net.praveen.artgallery.model.RegisterModel;
import net.praveen.artgallerybackend.dao.UserDAO;
import net.praveen.artgallerybackend.dto.Cart;
import net.praveen.artgallerybackend.dto.User;

@Component
public class RegisterHandler {
	
	@Autowired
	private UserDAO userDAO;
	
	
	public RegisterModel init() {
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user) {
		
		registerModel.setUser(user);
	}

	public String validateUser(User user, MessageContext error) {
		
		String transitionValue="success";
		
		//checking if password matches the confirm password
		if(!(user.getU_password().equals(user.getConfirmPassword()))) {
			
			error.addMessage(new MessageBuilder().error().source("confirmPassword").defaultText("Password does not match the confirm password!").build());
			
			
			transitionValue = "failure";
		}
		
		//check the uniqueness of the email id
		if(userDAO.getByEmail(user.getU_emailid())!=null) {
			
			error.addMessage(new MessageBuilder().error().source("u_emailid").defaultText("Email address is already used!").build());

			
			transitionValue="failure";
		}
		
		
		return transitionValue;
	}
	
	
	
	public String saveAll(RegisterModel model) {
		String transitionValue = "success";
		
		//fetch the user
		User user = model.getUser();
		
		if(user.getU_role().equals("USER")) {
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		
		//save the user
		userDAO.addUser(user);
		
		
		
		
		return transitionValue;
	}
}
