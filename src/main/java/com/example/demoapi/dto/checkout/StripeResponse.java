package com.example.demoapi.dto.checkout;

public class StripeResponse {
	private String sessionId;

	public StripeResponse(String sessionId) {
		super();
		this.sessionId = sessionId;
	}

	public StripeResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
