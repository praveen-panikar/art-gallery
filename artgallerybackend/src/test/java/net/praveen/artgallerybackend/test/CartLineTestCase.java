package net.praveen.artgallerybackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.praveen.artgallerybackend.dao.CartLineDAO;
import net.praveen.artgallerybackend.dao.ProductDAO;
import net.praveen.artgallerybackend.dao.UserDAO;
import net.praveen.artgallerybackend.dto.Cart;
import net.praveen.artgallerybackend.dto.CartLine;
import net.praveen.artgallerybackend.dto.Product;
import net.praveen.artgallerybackend.dto.User;

public class CartLineTestCase {

	private static AnnotationConfigApplicationContext context;
	
	
	private static CartLineDAO cartLineDAO = null;
	private static ProductDAO productDAO = null;
	private static UserDAO userDAO = null;
	
	private User user = null;
	private Product product = null;
	private Cart cart = null;
	private CartLine cartLine = null;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.praveen.artgallerybackend");
		context.refresh();
		cartLineDAO = (CartLineDAO)context.getBean("cartLineDAO");
		productDAO = (ProductDAO)context.getBean("productDAO");
		userDAO = (UserDAO)context.getBean("userDAO");
	}
	
	@Test
	public void testAddCartLine() {
		
		// fetch the user and then cart of that user
		User user = userDAO.getByEmail("kiran@gmail.com");		
		Cart cart = user.getCart();
		
		// fetch the product 
		Product product = productDAO.get(1);
		
		// Create a new CartLine
		cartLine = new CartLine();
		
		cartLine.setBuyingPrice(product.getProd_price());
		
		cartLine.setProductCount(cartLine.getProductCount()+1);
		
		cartLine.setTotal(cartLine.getProductCount()*product.getProd_price());
		
		cartLine.setAvailable(true);
		
		cartLine.setCartId(cart.getId());
		
		cartLine.setProduct(product);
		
		assertEquals("Failed to add the cartLine", true, cartLineDAO.add(cartLine));
		
		//update the cart
		cart.setGrandTotal(cart.getGrandTotal()+ cartLine.getTotal());
		cart.setCartLines(cart.getCartLines()+1);
		assertEquals("Failed to update the cart", true, cartLineDAO.updateCart(cart));
		
		
		
	}
	
}
