package net.praveen.artgallerybackend.dao;

import java.util.List;

import net.praveen.artgallerybackend.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();
	
	Category get(int id);

}
