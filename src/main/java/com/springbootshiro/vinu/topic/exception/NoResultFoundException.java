package com.springbootshiro.vinu.topic.exception;

/**
 * @author Vinod Borse
 * 19-Sep-2019
 */
public class NoResultFoundException extends RuntimeException {
	private static final long serialVersionUID = -1521907670967977489L;

	public NoResultFoundException(String message) {
		super(message);
	}
}
