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
		String[] storedInfo = new String[4];
		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));
			for (int i = 0; i < 4; i++) {
				storedInfo[i] = fileReader.readLine();
//				System.out.println(storedInfo[i]); //Testing
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

		User[] users = new User[4];
		String[] info = new String[4];
		for (int i = 0; i < 4; i++) {
			info = storedInfo[i].split(",");
			users[i] = userService.createUser(info);
			users[i].print(); //Testing
		} System.out.println(users);
		
		System.out.println(users[0].getName());
//		users[1].print();
//		users[2].print();
//		users[3].print();

		String responseUser;
		String responsePass;
		int loginAttempts = 0;
		boolean loggedIn = false;

		while (loggedIn != true) {
			System.out.println("Enter your email:");
			responseUser = scanner.nextLine();
			System.out.println("Enter your password:");
			responsePass = scanner.nextLine();
			userService.checkValidation(responseUser, responsePass, users[0]);
			if (userService.success == false) {
				System.out.println("Invalid login, please try again");
				loginAttempts++;
			} else if (userService.success == true) {
				loggedIn = true;
			}
			if (loginAttempts == 5) {
				System.out.println("Too many failed login attempts, you are now locked out.");
				break;
			}
		}
		scanner.close();
	}

}
