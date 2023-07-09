package com.simplilearn.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.simplilearn.model.Users;

public class UsersDao {
	public UsersDao() {}

	SessionFactory sessionFactory = new Configuration().configure("com/simplilearn/hibernate/hibernate.cfg.xml")
			.buildSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();

	public Integer saveOrUpdateUsers(Users user) {

		try {
			session.saveOrUpdate(user);
			transaction.commit();
			return user.getId();
		} catch (RuntimeException e) {
			throw e;
		}
	}

	public Users readUserById(int id) {

		try {
			Users users = session.get(Users.class, id);
			return users;
		} catch (RuntimeException e) {
			throw e;
		}

	}

	
}
