package net.praveen.artgallerybackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.praveen.artgallerybackend.dao.ProductDAO;
import net.praveen.artgallerybackend.dto.Product;


@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public Product get(int productId) {
		try {			
			return sessionFactory
					.getCurrentSession()
						.get(Product.class,Integer.valueOf(productId));			
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}
		return null;
	}

	@Override
	public List<Product> list() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Product" , Product.class)
						.getResultList();
	}

	//add
	@Override
	public boolean add(Product product) {
		try {			
			sessionFactory
					.getCurrentSession()
						.persist(product);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;
	}

	//update
	@Override
	public boolean update(Product product) {
		try {			
			sessionFactory
					.getCurrentSession()
						.update(product);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;	
	}

	//delete
	@Override
	public boolean delete(Product product) {
		try {
			product.setProd_status(false);
			// call the update method
			return this.update(product);
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;
	}

	
	
	@Override
	public List<Product> listActiveProducts() {

		String selectActiveProducts = "FROM Product WHERE prod_status = :active";
		
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveProducts,Product.class)
						.setParameter("active", true)
							.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {

		String selectActiveProductsByCategory = "FROM Product WHERE prod_status = :active AND fk_cat_id = :categoryId";
		
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveProductsByCategory, Product.class)
						.setParameter("active", true)
							.setParameter("categoryId", categoryId)
								.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {

		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Product WHERE prod_status = :active ORDER BY pk_prod_id", Product.class)
						.setParameter("active", true)
						.setFirstResult(0)
						.setMaxResults(count)
								.getResultList();

	}

}
