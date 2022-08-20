package com.springrest.courses.exceptions;

public class ApiResponse {

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccessful() {
		return this.isSuccessful;
	}

	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApiResponse(String message, boolean isSuccessful) {
		super();
		this.message = message;
		this.isSuccessful = isSuccessful;
	}

	public void setSuccessful(boolean isSuccessful) {
		this.isSuccessful = isSuccessful;
	}

	private String message;
	private boolean isSuccessful;
}
