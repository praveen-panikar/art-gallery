package net.praveen.artgallerybackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.praveen.artgallerybackend.dao.CategoryDAO;
import net.praveen.artgallerybackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("net.praveen.artgallerybackend");
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	
	
/**	@Test
	public void testAddCategory() {
		
		category = new Category();
		
		//category.setPk_cat_id(1);
		category.setCat_name("Acrylic");
		
		assertEquals("Successfully added a category inside the table",true,categoryDAO.add(category));
	}**/
	
//	@Test
//	public void testGetCategory() {
//		category = categoryDAO.get(2);
//		
//		assertEquals("Successfully fetched a single a category from the table","Water",category.getCat_name());
//
//	}

//	@Test
//	public void testUpdateCategory() {
//		category = categoryDAO.get(3);
//		
//		category.setCat_name("Acrylic Colour");
//		assertEquals("Successfully updated a single a category in the table",true,categoryDAO.update(category));
//
//	}
	
//	@Test
//	public void testDeleteCategory() {
//		category = categoryDAO.get(2);
//
//		assertEquals("Successfully updated a single a category in the table",true,categoryDAO.delete(category));
//
//	}
	

//	@Test
//	public void testListCategory() {
//
//		assertEquals("Successfully fetched the list of category from the table",2,categoryDAO.list().size());
//
//	}
	
//	@Test
//	public void testCRUDCategory() {
//	
//		
//	}
	
	
	
	
	
	
}
