package com.example.demoapi.exceptions;

public class CartItemNotExistException extends IllegalArgumentException {
	public CartItemNotExistException(String msg) {
		super(msg);
	}
}
