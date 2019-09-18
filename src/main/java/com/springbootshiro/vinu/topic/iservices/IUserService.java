package com.springbootshiro.vinu.topic.iservices;

import com.springbootshiro.vinu.topic.models.UserAuthentication;

/**
 * @author Vinod Borse
 * 05-Sep-2017
 */
public interface IUserService {
	
	UserAuthentication findByUsername(String username);
	
	void addUser(String userName, String firstName, String lastName, String password, String passwordSalt);
}
