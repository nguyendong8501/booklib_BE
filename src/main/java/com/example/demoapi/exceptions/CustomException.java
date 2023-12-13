package com.example.demoapi.exceptions;

public class CustomException extends IllegalArgumentException {
	public CustomException(String msg) {
		super(msg);
	}
}
