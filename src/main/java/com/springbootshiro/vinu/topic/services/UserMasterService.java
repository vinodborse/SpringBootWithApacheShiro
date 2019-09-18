package com.springbootshiro.vinu.topic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springbootshiro.vinu.topic.dao.IUserMasterDao;
import com.springbootshiro.vinu.topic.iservices.IUserMasterService;
import com.springbootshiro.vinu.topic.models.Actor;
import com.springbootshiro.vinu.topic.models.Movie;
import com.springbootshiro.vinu.topic.models.UserMaster;

/**
 * @author Vinod Borse
 * 05-Sep-2017
 */
@Service
public class UserMasterService implements IUserMasterService{
	 @Autowired
	  private IUserMasterDao userMasterDao;

	@Transactional(readOnly = true)
	  public UserMaster findByUsername(String username) {
		UserMaster users = userMasterDao.findByUsername(username);
	    return users;
	  }

	@Override
	public boolean addUser(int userId, String username, String password) {
		boolean addUser = userMasterDao.addUser(userId, username, password);
	    return addUser;
	}
	
	@Override
	public boolean addMovie(Movie movie) {
		boolean addmovie = userMasterDao.addMovie(movie);
	    return addmovie;
	}

	@Override
	public boolean addActor(Actor actor) {
		boolean addActor = userMasterDao.addActor(actor);
	    return addActor;
	}

	@Override
	public Movie findByMovieName(String movieName) {
		Movie movie = userMasterDao.findByMovieName(movieName);
	    return movie;
	}
	
	
	
	
}
