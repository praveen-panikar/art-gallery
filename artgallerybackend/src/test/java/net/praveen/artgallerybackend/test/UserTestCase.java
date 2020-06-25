package net.praveen.artgallerybackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.praveen.artgallerybackend.dao.UserDAO;
import net.praveen.artgallerybackend.dto.Cart;
import net.praveen.artgallerybackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.praveen.artgallerybackend");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	

//	@Test
//	public void testAdd() {
//		
//		user= new User();
//		user.setU_name("abc1");
//		user.setU_username("abc1");
//		user.setU_password("abc1");
//		user.setU_address("bhosari");
//		user.setU_emailid("abc1@gmail.com");
//		user.setU_contact_number("1234567890");
//		user.setU_role("USER");
//		
//		//add user
//		assertEquals("Failed to add user!",true,userDAO.addUser(user));
//		
//		if(user.getU_role().equals("USER")) {
//			
//			//create a cart for this user
//			cart=new Cart();
//			cart.setUser(user);
//			
//			//add the cart
//			assertEquals("Failed to add cart!",true,userDAO.addCart(cart));
//		}
//		
//		
//		
//	}
	
//	

	@Test
	public void testUpdateCart() {
		
		//fetch the user by email
		user= userDAO.getByEmail("ab@gmail.com");
		
		//get the cart of the user
		cart = user.getCart();
		
		cart.setGrandTotal(555);
		
		cart.setCartLines(2);
		
		//assertEquals("Failed to update the cart!", true, userDAO.updateCart(cart));
		
		
	}
	

	
}
