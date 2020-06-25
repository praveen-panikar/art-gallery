package net.praveen.artgallerybackend.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.praveen.artgallerybackend.dao.UserDAO;
import net.praveen.artgallerybackend.dto.Cart;
import net.praveen.artgallerybackend.dto.User;


@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public boolean addUser(User user) {
		try {			
			sessionFactory.getCurrentSession().persist(user);			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	

	@Override
	public User getByEmail(String email) {
		String selectQuery = "FROM User WHERE u_emailid= :email";
		
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery, User.class)
					.setParameter("email",email)
					.getSingleResult();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
	}

}
