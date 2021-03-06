package com.springbootshiro.vinu.topic.dao;

import com.springbootshiro.vinu.topic.models.UserAuthentication;

/**
 * @author Vinod Borse
 * 19-Sep-2019
 */
public interface IUserAuthenticationDao {
	
	void insertUserAuthentication(UserAuthentication userAuthentication);

	UserAuthentication findByUsername(String username);
}
