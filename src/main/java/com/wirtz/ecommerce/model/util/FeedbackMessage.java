package com.wirtz.ecommerce.model.util;

public class FeedbackMessage {
	private String message;

	private boolean error = false;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}
}
