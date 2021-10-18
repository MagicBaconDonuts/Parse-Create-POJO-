package com.coderscampus.UserLogin;

public class UserService {

	public User createUser(String[] info) {
		User user = new User();
		user.setUsername(info[0]);
		user.setPassword(info[1]);
		user.setName(info[2]);
		return user;
	}
	
	boolean success = false;

	public void checkValidation(String username, String password, User users) {
		if (username.equalsIgnoreCase(users.getUsername()) && password.equals(users.getPassword())) {
			System.out.println("Welcome: " + users.getName());
			success = true;
		}
	}

}
