package com.springbootshiro.vinu.topic.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springbootshiro.vinu.topic.dao.IUserMasterDao;
import com.springbootshiro.vinu.topic.models.Actor;
import com.springbootshiro.vinu.topic.models.Movie;
import com.springbootshiro.vinu.topic.models.UserMaster;

/**
 * @author Vinod Borse
 * 05-Sep-2017
 */
@Repository
public class UserMasterDao implements IUserMasterDao{
	
	@PersistenceContext
	  private EntityManager entityManager;
	
	 /* public UserMaster findByUsername(String username) {
	    Query queryUser = entityManager
	        .createNamedQuery("findUserMasterByUsername");
	    queryUser.setParameter("username", username);

	    UserMaster user = null;
	    try {
	      user = (UserMaster) queryUser.getSingleResult();
	    } catch (NoResultException nre) {
	      // Do Nothing
	    }
	    return user;
	  }*/

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

	@Transactional
	@Override
	public boolean addMovie(Movie movie) {
		entityManager.merge(movie);
		return true;
	}
	
	@Transactional
	@Override
	public boolean addActor(Actor actor) {
		entityManager.merge(actor);
		return true;
	}

	@Transactional
	@Override
	public Movie findByMovieName(String movieName) {
		TypedQuery<Movie> q = entityManager.createQuery("SELECT m FROM Movie AS m WHERE m.movieName = :movieName",Movie.class);
		q.setParameter("movieName", movieName);
		Movie movie = q.getSingleResult();
		//long id = movie.getMovieId();
		//TypedQuery<Movie> q1 = entityManager.createQuery("SELECT ma FROM Movie AS m WHERE m.movieName = :movieName",Movie.class);
		//q1.setParameter("movieName", movieName);
		return movie;
	}

}
