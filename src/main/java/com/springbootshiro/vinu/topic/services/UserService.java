package com.springbootshiro.vinu.topic.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootshiro.vinu.topic.dao.IUserAuthenticationDao;
import com.springbootshiro.vinu.topic.iservices.IUserService;
import com.springbootshiro.vinu.topic.models.UserAuthentication;

/**
 * @author Vinod Borse
 * 19-Sep-2019
 */
@Service
public class UserService implements IUserService{
	@Autowired
	private IUserAuthenticationDao userAuthenticationDao;

	@Override
	public void addUser(String userName, String firstName, String lastName, String password, String passwordSalt) {
		UserAuthentication userAuth = new UserAuthentication();
		userAuth.setUsername(userName);
		userAuth.setPassword(password);
		userAuth.setPasswordSalt(passwordSalt);
		Date createdDate = new Date();
		userAuth.setCreatedAt(createdDate);
		userAuth.setUpdatedAt(createdDate);
		userAuthenticationDao.insertUserAuthentication(userAuth);
	}

	@Override
	public UserAuthentication findByUsername(String username) {
		UserAuthentication users = userAuthenticationDao.findByUsername(username);
		return users;
	}
}