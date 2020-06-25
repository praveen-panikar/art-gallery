package net.praveen.artgallerybackend.dao;

import java.util.List;

import net.praveen.artgallerybackend.dto.Cart;
import net.praveen.artgallerybackend.dto.CartLine;

public interface CartLineDAO {

	//common methods
	public CartLine get(int id);	
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean delete(CartLine cartLine);
	public List<CartLine> list(int cartId);

	//other business method related to cart lines
	public List<CartLine> listAvailable(int cartId);
	
	// fetch the CartLine based on cartId and productId
	public CartLine getByCartAndProduct(int cartId, int productId);
	
	//update a cart
	boolean updateCart(Cart cart);
	
}
