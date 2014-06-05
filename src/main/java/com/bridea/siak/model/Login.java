package com.bridea.siak.model;

import java.io.Serializable;

public class Login implements Serializable {
	
	private String password;

	public Login() {
		// TODO Auto-generated constructor stub
	}

	public Login(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
