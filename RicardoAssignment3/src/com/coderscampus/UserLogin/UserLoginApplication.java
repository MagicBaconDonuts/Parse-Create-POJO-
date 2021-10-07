package com.coderscampus.UserLogin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) {

		// 1.Ask for username 2. Ask for password 3. Create method to valid user info
		// .equals if true print match if not no match 5. if fail on the fifth try stop

		UserService userService = new UserService();
		Scanner scanner = new Scanner(System.in);
		String responseUser;
		String responsePass;
		int loginAttempets = 0;

		
		while (loginAttempets < 5) {
			System.out.println("Enter your email:");
			responseUser = scanner.nextLine();
			System.out.println("Enter your password:");
			responsePass = scanner.nextLine();
			userService.checkValidation(responseUser, responsePass);
		}
		scanner.close();

		BufferedReader fileReader = null;
		String[] storedInfo = new String[4];
		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));
			for (int i = 0; i < 4; i++) {
				storedInfo[i] = fileReader.readLine();
				System.out.println(storedInfo[i]);
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
			users[i].print();
		}
//		User[] userTest = new User[2];

	}

}
