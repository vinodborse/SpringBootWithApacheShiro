package com.springbootshiro.vinu.topic.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springbootshiro.vinu.topic.dao.IUserAuthenticationDao;
import com.springbootshiro.vinu.topic.models.UserAuthentication;

/**
 * @author Vinod Borse
 * 05-Sep-2017
 */
@Repository
public class UserAuthenticationDao implements IUserAuthenticationDao  {
	@PersistenceContext
	  private EntityManager entityManager;
	
	@Transactional
	@Override
	public void insertUserAuthentication(UserAuthentication userAuthentication) {
		entityManager.persist(userAuthentication);
	}
	
	@Transactional
	@Override
	public UserAuthentication findByUsername(String username) {
		TypedQuery<UserAuthentication> q = entityManager.createQuery("SELECT u FROM UserAuthentication AS u WHERE u.username = :username",UserAuthentication.class);
		q.setParameter("username", username);
		try{
			UserAuthentication userAuthentication = q.getSingleResult();
			return userAuthentication;
		}catch(NoResultException nre){
		return null;	
		}
		
	}
}