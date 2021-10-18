package com.coderscampus.UserLogin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) {

		UserService userService = new UserService();
		Scanner scanner = new Scanner(System.in);

		BufferedReader fileReader = null;
		String storedInfo;
		User[] users = new User[4];
		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));
			for (int i = 0; i < 4; i++) {
				storedInfo = fileReader.readLine();
				users[i] = userService.createUser(storedInfo.split(","));
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("There was a File Not Found Exception");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("There was a I/O exception");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("There was a I/O exception");
				e.printStackTrace();
			}
		}

		for(User user: users) {
			System.out.println(user);
		}
//		System.out.println(users[0].getName());

		String responseUser;
		String responsePass;
		int loginAttempts = 0;
		boolean loggedIn = false;

		while (loggedIn != true) {
			System.out.println("Enter your email:");
			responseUser = scanner.nextLine();
			System.out.println("Enter your password:");
			responsePass = scanner.nextLine();
			User user = userService.checkValidation(responseUser, responsePass, users);
			if (user == null) {
				System.out.println("Invalid login, please try again");
				loginAttempts++;
			} else if (user != null) {
				loggedIn = true;
				System.out.println(user);
			}
			if (loginAttempts == 5) {
				System.out.println("Too many failed login attempts, you are now locked out.");
				break;
			}
		}
		scanner.close();
	}

}
