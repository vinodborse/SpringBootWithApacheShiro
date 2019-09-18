package com.springbootshiro.vinu.topic.iservices;

import com.springbootshiro.vinu.topic.models.Actor;
import com.springbootshiro.vinu.topic.models.Movie;
import com.springbootshiro.vinu.topic.models.UserMaster;

/**
 * @author Vinod Borse
 * 05-Sep-2017
 */
public interface IUserMasterService {
	UserMaster findByUsername(String username);
	boolean addUser(int userId, String username, String password);
	boolean addMovie(Movie movie);
	boolean addActor(Actor actor);
	Movie findByMovieName (String movieName);
}
