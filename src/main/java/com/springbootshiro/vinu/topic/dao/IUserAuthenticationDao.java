package com.springbootshiro.vinu.topic.dao;

import com.springbootshiro.vinu.topic.models.UserAuthentication;

/**
 * @author Vinod Borse
 * 05-Sep-2017
 */
public interface IUserAuthenticationDao {
	
	void insertUserAuthentication(UserAuthentication userAuthentication);

	UserAuthentication findByUsername(String username);
}
