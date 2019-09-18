package com.springbootshiro.vinu.topic.exception;

/**
 * @author Vinod Borse
 * 05-Sep-2017
 */
public class UnauthenticatedException extends RuntimeException {
	private static final long serialVersionUID = 1828846487324351358L;

	public UnauthenticatedException(String message) {
		super(message);
	}
}
