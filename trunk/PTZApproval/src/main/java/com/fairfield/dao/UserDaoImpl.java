package com.fairfield.dao;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.fairfield.rules.models.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public User getUserByName(String name) {
		return (User)em.createNativeQuery("select * from jbpm_id_user where NAME_ = ?1",User.class)
		.setParameter(1,name).getSingleResult();
	}
}
