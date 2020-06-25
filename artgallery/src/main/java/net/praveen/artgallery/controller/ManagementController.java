package net.praveen.artgallery.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.praveen.artgallery.util.FileUploadUtility;
import net.praveen.artgallery.validator.ProductValidator;
import net.praveen.artgallerybackend.dao.CategoryDAO;
import net.praveen.artgallerybackend.dao.ProductDAO;
import net.praveen.artgallerybackend.dto.Category;
import net.praveen.artgallerybackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);
	
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView showManageProduct(@RequestParam(name="operation",required=false)String operation) {		

		ModelAndView mv = new ModelAndView("page");	
			
		mv.addObject("userClickManageProducts",true);
		mv.addObject("title","Manage Products");	
	
		
		Product nProduct = new Product();
		
		// assuming that the user is ADMIN
		
		nProduct.setFk_u_id(1);;
		nProduct.setProd_status(true);

		mv.addObject("product", nProduct);
		
		if(operation != null) {
			if(operation.equals("product")){
				mv.addObject("message", "Product submitted successfully!");
			}
			else if(operation.equals("category")) {
				mv.addObject("message", "Category submitted successfully!");
			}
		}
		return mv;
	}
	
	
	
	@RequestMapping(value="/{id}/product", method=RequestMethod.GET)
	public ModelAndView showEditProduct(@PathVariable int id) {		

		ModelAndView mv = new ModelAndView("page");	
			
		mv.addObject("userClickManageProducts",true);
		mv.addObject("title","Manage Products");	
	
		//fetch the product form db
		Product nProduct = productDAO.get(id);
		
		//set the product fetch from db
		mv.addObject("product", nProduct);
		
		return mv;
	}
	
	
	
	
	
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results, Model model,
			HttpServletRequest request) {
		
		if(mProduct.getPk_prod_id()==0) {
			new ProductValidator().validate(mProduct, results);
		}
		else {
			if(!mProduct.getFile().getOriginalFilename().equals("")) {
				new ProductValidator().validate(mProduct, results);
			}
		}
		
		//check if there are any errors
		if(results.hasErrors()) {
			
			model.addAttribute("userClickManageProducts",true);
			model.addAttribute("title","Manage Products");
			model.addAttribute("message","Validation failed for Product Submission!");

			return "page";
		}
		
		logger.info(mProduct.toString());
		
		//create a ew product record
		if(mProduct.getPk_prod_id()==0) {
			productDAO.add(mProduct);
		}
		else {
			productDAO.update(mProduct);
		}
		
		
		
		if(!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request,mProduct.getFile(), mProduct.getProd_code());
		}
		
		
		
		return "redirect:/manage/products?operation=product";
	}
	
	
	
	
	
	
	@RequestMapping(value = "/product/{id}/activation",method=RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id) {
		//is going to fetch the product from the db
		Product product = productDAO.get(id);
		
		boolean isActive = product.isProd_status();
		
		product.setProd_status(!product.isProd_status());
		
		productDAO.update(product);
		
		return (isActive)? 
				"You have successfully deactivated the product with id" + product.getPk_prod_id()
				: "You have successfully activated the product with id" + product.getPk_prod_id();
	}
	
	
	//to handle category submission
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category) {
		
		categoryDAO.add(category);
		return "redirect:/manage/products?operation=category";
		
	}
	
	
	
	@ModelAttribute("categories") 
	public List<Category> getCategories() {
		return categoryDAO.list();
	}
	
	
	@ModelAttribute("category")
	public Category getCategory() {
		return new Category();
	}
	

}
