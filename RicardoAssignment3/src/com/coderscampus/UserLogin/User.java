package com.coderscampus.UserLogin;

public class User {
	private String username;
	private String password;
	private String name;
	
	public void print() {
		System.out.println(username + password + name);
	}
	
	public String toString() {
		return username + password + name;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
