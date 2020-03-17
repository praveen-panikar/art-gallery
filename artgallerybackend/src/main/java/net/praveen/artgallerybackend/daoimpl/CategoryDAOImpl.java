package net.praveen.artgallerybackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.praveen.artgallerybackend.dao.CategoryDAO;
import net.praveen.artgallerybackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();
	
	static {
		Category category=new Category();
		
		category.setCat_id(1);
		category.setCat_name("oil");
		
		categories.add(category);
		
		//2nd cat
		category=new Category();
		
		category.setCat_id(2);
		category.setCat_name("water");
		
		categories.add(category);
		
		//3rd cat
		category=new Category();
		
		category.setCat_id(3);
		category.setCat_name("acrylic");
		
		categories.add(category);
	}
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		
		for(Category category:categories) {
			if(category.getCat_id() == id) {
				return category;
			}
		}
		return null;
	}

}
