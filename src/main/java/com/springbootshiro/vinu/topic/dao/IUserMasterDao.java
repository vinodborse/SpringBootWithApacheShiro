package com.springbootshiro.vinu.topic.dao;

import com.springbootshiro.vinu.topic.models.UserMaster;

/**
 * @author Vinod Borse
 * 19-Sep-2019
 */
public interface IUserMasterDao {
	UserMaster findByUsername(String username);
	boolean addUser(int userId, String username, String password);
}
