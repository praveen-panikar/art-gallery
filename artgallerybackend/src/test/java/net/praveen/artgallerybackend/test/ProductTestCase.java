package net.praveen.artgallerybackend.test;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.praveen.artgallerybackend.dao.ProductDAO;
import net.praveen.artgallerybackend.dto.Product;

public class ProductTestCase {
	

	private static AnnotationConfigApplicationContext context;
	
	
	private static ProductDAO productDAO;
	
	
	private Product product;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.praveen.artgallerybackend");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
	}
	
//	@Test
//	public void testCRUDProduct() {
//		
//		// create operation
//		product = new Product();
//				
//		product.setFk_cat_id(3);
//		product.setFk_u_id(3);
//		product.setProd_description("description");
//		product.setProd_img_url("idk");
//		product.setProd_name("TP");
//		product.setProd_price(9000);
//		product.setProd_status(true);
//		
//		assertEquals("Something went wrong while inserting a new product!",
//				true,productDAO.add(product));		
//		
//		
//		// reading and updating the category
//		product = productDAO.get(4);
//		product.setProd_name("Scenary");
//		assertEquals("Something went wrong while updating the existing record!",
//				true,productDAO.update(product));		
//				
//		assertEquals("Something went wrong while deleting the existing record!",
//				true,productDAO.delete(product));		
//		
//		// list
//		assertEquals("Something went wrong while fetching the list of products!",
//				6,productDAO.list().size());		
//				
//	}
	
	@Test
	public void testListActiveProducts()
	{
		assertEquals("Something went wrong while fetching the list of products!",
				5,productDAO.listActiveProducts().size());	
	}
	
	@Test
	public void testListActiveProductsByCategory() {
		assertEquals("Something went wrong while fetching the list of products!",
				2,productDAO.listActiveProductsByCategory(1).size());
		assertEquals("Something went wrong while fetching the list of products!",
				2,productDAO.listActiveProductsByCategory(2).size());
	} 
	
	@Test
	public void testGetLatestActiveProduct() {
		assertEquals("Something went wrong while fetching the list of products!",
				2,productDAO.getLatestActiveProducts(2).size());
		
	} 

}
