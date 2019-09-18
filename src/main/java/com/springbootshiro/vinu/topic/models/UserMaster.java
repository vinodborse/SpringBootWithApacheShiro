package com.springbootshiro.vinu.topic.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Vinod Borse
 * 05-Sep-2017
 */
@Entity
@Table(name = "user_master")
public class UserMaster implements Serializable{

  /**
	 * 
	 */
	private static final long serialVersionUID = 4730808413805989818L;

@Id
  @Column(name = "user_id")
  private int userId;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

    
  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }

}

