package com.naresh.exception;

//User Defined Exception
public class DBException extends Exception{

	public DBException(Exception e, String message) {
		super(message, e);
	}
	
}
