package com.springbootshiro.vinu.topic.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Vinod Borse
 * 05-Sep-2017
 */
@Entity
@Table(name = "movie")
public class Movie {
	
	@Id
	@Column(name = "movie_id")
	private long movieId;
	
	@Column(name = "movie_name")
	private String movieName;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "movie_actor", joinColumns = { @JoinColumn(name = "movie_id") }, inverseJoinColumns = { @JoinColumn(name = "actor_id") })
	private Set<Actor> movieActors = new HashSet<Actor>(0);

	
	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Set<Actor> getMovieActors() {
		return movieActors;
	}

	public void setMovieActors(Set<Actor> movieActors) {
		this.movieActors = movieActors;
	}
}
