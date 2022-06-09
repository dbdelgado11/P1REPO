package com.newrev.p1.exceptions;

public class LoginException extends RuntimeException{

	public LoginException() {
	}
	
	public LoginException(String message) {
		super(message);
	}
}
