package com.HDAO.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.HDAO.dao.UserDAO;
import com.HDAO.model.User;

@Transactional
@Repository("UsersDAO")
public class UsersDAOImpl implements UserDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addUser(User user) {
		
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
			}
			catch(Exception e)
			{
				
				return false;
			}
	}

	@Override
	public boolean updateUser(User user) {
		
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(user);		
			return true;
			}
			catch(Exception e)
			{
				return false;
			}
		
	}

	@Override
	public boolean deleteUser(User user) {
		
		try {
			sessionFactory.getCurrentSession().delete(user);
			return true;
			}
			catch(Exception e)
			{
				return false;
			}
	}

	@Override
	public List<User> displayUsers() {
		
		return sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}

	@Override
	public User displayUser(int userid) {
		Session session= sessionFactory.getCurrentSession();
		Query query=session.createQuery("from com.HDAO.model.User where userid= :id");
		return (User)query.setParameter("uid", userid).getResultList().get(0);
	}

	@Override
	public User displayUserByName(String username) {
		Session session= sessionFactory.getCurrentSession();
		Query query=session.createQuery("from com.HDAO.model.User where username= :uname");
		return (User)query.setParameter("uname", username).getResultList().get(0);
	}

}
