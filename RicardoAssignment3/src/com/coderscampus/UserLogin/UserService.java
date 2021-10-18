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

	public User checkValidation(String username, String password, User[] users) {
		for (User user : users) {
			if (username.equalsIgnoreCase(user.getUsername()) && password.equals(user.getPassword())) {
				System.out.println("Welcome: " + user.getName());
				success = true;
				return user;
			}
		}
		return null;
	}

}
