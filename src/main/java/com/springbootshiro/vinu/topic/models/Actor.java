package com.springbootshiro.vinu.topic.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Vinod Borse
 * 05-Sep-2017
 */
@Entity
@Table(name = "actor")
public class Actor {
	
	@Id
	@Column(name = "actor_id")
	private long actorId;
	
	@Column(name = "actor_name")
	private String actorName;

	
	public long getActorId() {
		return actorId;
	}

	public void setActorId(long actorId) {
		this.actorId = actorId;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
}
