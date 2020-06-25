package net.praveen.artgallery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.praveen.artgallery.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	
	@RequestMapping("/show")
	public ModelAndView showCart(@RequestParam(name = "result", required = false) String result) {
		
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("title", "User Cart");
		mv.addObject("userClickShowCart", true);
		
		if(result!=null) {
			switch(result) {
				
				case "deleted":
					mv.addObject("message", "CartLine has been successfully removed!");
					break;
					
				case "added":
					mv.addObject("message", "CartLine has been successfully added!");
					break;

			}
		}
		
		
		
		mv.addObject("cartLines", cartService.getCartLines());
		
		return mv;
		
	}
	
	@RequestMapping("/{cartLineId}/delete")
	public String updateCart(@PathVariable int cartLineId) {
		String response = cartService.deleteCartLine(cartLineId);
		return "redirect:/cart/show?" + response;
	}
	
	@RequestMapping("/add/{productId}/product")
	public String addCart(@PathVariable int productId) {
		String response = cartService.addCartLine(productId);
		return "redirect:/cart/show?" + response;
	}
}
