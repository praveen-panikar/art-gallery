package net.praveen.artgallery.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.praveen.artgallery.model.UserModel;
import net.praveen.artgallerybackend.dao.CartLineDAO;
import net.praveen.artgallerybackend.dao.ProductDAO;
import net.praveen.artgallerybackend.dto.Cart;
import net.praveen.artgallerybackend.dto.CartLine;
import net.praveen.artgallerybackend.dto.Product;

@Service("cartService")
public class CartService {

	@Autowired
	private CartLineDAO cartLineDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private HttpSession session;
	
	//return the cart of the user who has logged in
	private Cart getCart() {
		return ((UserModel)session.getAttribute("userModel")).getCart();
	}
	
	
	//returns the entire cartline
	public List<CartLine> getCartLines() {
		
		return cartLineDAO.list(this.getCart().getId());

	}


	public String deleteCartLine(int cartLineId) {
		
		//fetch the  cartline
		CartLine cartLine = cartLineDAO.get(cartLineId);
		
		if(cartLine ==null) {
			return "result=error";
		}
		else {
			//update the cart
			Cart cart = this.getCart();
			cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
			cart.setCartLines(cart.getCartLines() - 1);
			cartLineDAO.updateCart(cart);
			
			//remove the cart line
			cartLineDAO.delete(cartLine);
			
			return "result=deleted";
		}
	}


	public String addCartLine(int productId) {
		
		String response = null;
		
		Cart cart = this.getCart();
		
		CartLine cartLine = cartLineDAO.getByCartAndProduct(cart.getId(), productId);
		
		if(cartLine == null) {
			//add a new cartline
			cartLine =new CartLine();
			
			//fetch the product
			Product product = productDAO.get(productId);
			
			cartLine.setCartId(cart.getId());
			
			cartLine.setProduct(product);
			
			cartLine.setBuyingPrice(product.getProd_price());
			
			cartLine.setTotal(product.getProd_price());
			
			cartLine.setAvailable(true);
			
			cartLineDAO.add(cartLine);
			
			cart.setCartLines(cart.getCartLines() + 1);
			cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
			
			cartLineDAO.updateCart(cart);
			
			
			response = "result=added";
		}
		
		
		
		
		return response;
		
	}
	
}
