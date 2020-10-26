package com.projects.springserviciosmeetpeople.exception;



public class NameUserNotRepeated extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NameUserNotRepeated() {
		super("NameUser already exists, must change it");
	}

}
