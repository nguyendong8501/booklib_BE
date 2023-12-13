package com.example.demoapi.exceptions;

public class AuthenticationFailException extends IllegalArgumentException {
	public AuthenticationFailException(String msg) {
		super(msg);
	}
}
