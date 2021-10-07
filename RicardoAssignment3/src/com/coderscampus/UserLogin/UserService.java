package com.coderscampus.UserLogin;

public class UserService {
	
	public User createUser(String[] info) {
		User user = new User();
		user.setUsername(info[0]);
		user.setPassword(info[1]);
		user.setName(info[2]);
		System.out.println("UserCreated");
		return user;
	}
	
	public void checkValidation(String username, String password ) {
//		if(username.equals() {
//			
//		}
	}
	
}
