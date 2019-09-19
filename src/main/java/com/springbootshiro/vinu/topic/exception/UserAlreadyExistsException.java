package com.springbootshiro.vinu.topic.exception;

/**
 * @author Vinod Borse
 * 19-Sep-2019
 */
public class UserAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = 60979624435191889L;

	public UserAlreadyExistsException(String message) {
		super(message);
	}
}
