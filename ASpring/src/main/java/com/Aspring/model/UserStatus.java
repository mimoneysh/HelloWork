package com.Aspring.model;



public class UserStatus {
	
	private int statusCode;
	private String message;
	private User user;

	



	public UserStatus(int statusCode, String message, User user) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setStatusCode(int i) {
		// TODO Auto-generated method stub
		
	}

	public void setMessage(String string) {
		// TODO Auto-generated method stub
		
	}

}
