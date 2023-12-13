package com.example.demoapi.exceptions;

public class UpdateFailException extends IllegalArgumentException {
	public UpdateFailException(String msg) {
		super(msg);
	}
}
