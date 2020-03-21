package net.praveen.artgallerybackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.praveen.artgallerybackend.dao.CategoryDAO;
import net.praveen.artgallerybackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private static List<Category> categories = new ArrayList<>();

	/**
	 * static { Category category=new Category();
	 * 
	 * category.setPk_cat_id(1); category.setCat_name("oil");
	 * 
	 * categories.add(category);
	 * 
	 * //2nd cat category=new Category();
	 * 
	 * category.setPk_cat_id(2); category.setCat_name("water");
	 * 
	 * categories.add(category);
	 * 
	 * //3rd cat category=new Category();
	 * 
	 * category.setPk_cat_id(3); category.setCat_name("acrylic");
	 * 
	 * categories.add(category); }
	 **/

	@Override
	public List<Category> list() {

		String selectActiveCategory = "FROM Category WHERE cat_status = :cat_status";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("cat_status", true);
		
		return query.getResultList();
	}

	// getting single category based on id
	@Override
	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) {

		try {
			// add category to the database table
			sessionFactory.getCurrentSession().persist(category);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	// updating a single category
	@Override
	public boolean update(Category category) {
		try {

			sessionFactory.getCurrentSession().update(category);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		
		category.setCat_status(false);
		
		try {

			sessionFactory.getCurrentSession().update(category);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
