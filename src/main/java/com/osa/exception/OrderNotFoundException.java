package com.osa.exception;

public class OrderNotFoundException extends Exception{
	
	public OrderNotFoundException() {}
	
	public OrderNotFoundException(String msg){
		super(msg);
	}

}
