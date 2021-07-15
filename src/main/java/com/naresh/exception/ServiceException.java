package com.naresh.exception;

//User Defined Exception
public class ServiceException extends Exception{

	public ServiceException(Exception e, String message) {
		super(message, e);
	}

	public ServiceException(String message) {
		super(message);
	}
	
}
