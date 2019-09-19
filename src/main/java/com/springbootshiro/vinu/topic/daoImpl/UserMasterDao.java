package com.springbootshiro.vinu.topic.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springbootshiro.vinu.topic.dao.IUserMasterDao;
import com.springbootshiro.vinu.topic.models.UserMaster;

/**
 * @author Vinod Borse
 * 19-Sep-2019
 */ 
@Repository
public class UserMasterDao implements IUserMasterDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional //Instead of adding @Transactional on each method we can add it directly on class level.
	@Override
	public UserMaster findByUsername(String username) {
		TypedQuery<UserMaster> q = entityManager.createQuery("SELECT u FROM UserMaster AS u WHERE u.username = :username",UserMaster.class);
		q.setParameter("username", username);
		UserMaster userMaster = q.getSingleResult();
		return userMaster;
	}

	@Transactional
	@Override
	public boolean addUser(int userId, String username, String password) {
		UserMaster userMaster = new UserMaster();
		userMaster.setUserId(userId);
		userMaster.setUsername(username);
		userMaster.setPassword(password);
		entityManager.merge(userMaster);
		return true;
	}
}
