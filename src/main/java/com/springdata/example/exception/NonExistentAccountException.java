package com.springdata.example.exception;

public class NonExistentAccountException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1865756875019372743L;

	public NonExistentAccountException (String message) {
		super(message);
	}

}
