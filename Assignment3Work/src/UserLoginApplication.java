import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserLoginApplication {

	public static void main(String[] args) {
		
		String line;
		User[] users = new User[4];
		UserService Service = new UserService();
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader("data.txt"));
			while((line = fileReader.readLine()) != null) {
				for(int i = 0; i < 4; i++) {
					users[i] = Service.createUser(line.split(","));
					System.out.println(users[0]);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not found Exception");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("There was a I/O Excpetion");
			e.printStackTrace();
		}

	}

}
