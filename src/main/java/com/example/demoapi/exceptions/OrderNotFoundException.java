package com.example.demoapi.exceptions;

public class OrderNotFoundException extends IllegalArgumentException {
	public OrderNotFoundException(String msg) {
		super(msg);
	}
}
