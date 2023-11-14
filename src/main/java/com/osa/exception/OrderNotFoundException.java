package com.osa.exception;

public class OrderNotFoundException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderNotFoundException() {}
	
	public OrderNotFoundException(String msg){
		super(msg);
	}

}
