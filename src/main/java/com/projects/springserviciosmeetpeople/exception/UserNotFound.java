package com.projects.springserviciosmeetpeople.exception;

public class UserNotFound extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFound() {
		super("user does not exist or it is not registered");
	}
	
	

}
