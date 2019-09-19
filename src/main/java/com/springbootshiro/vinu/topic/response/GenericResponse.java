package com.springbootshiro.vinu.topic.response;

/**
 * @author Vinod Borse
 * 19-Sep-2019
 */
public class GenericResponse {
	private String response;

	public GenericResponse() {
		super();
	}
  
	public GenericResponse(String response) {
		this.response = response;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
}