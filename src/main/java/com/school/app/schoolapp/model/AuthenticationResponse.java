package com.school.app.schoolapp.model;

public class AuthenticationResponse {
	
	String jwt;

	public AuthenticationResponse(String jwt) {
		this.jwt =jwt;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
	

}
