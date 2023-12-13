package com.example.demoapi.exceptions;

public class ProductNotExistException extends IllegalArgumentException {
	public ProductNotExistException(String msg) {
		super(msg);
	}
}
