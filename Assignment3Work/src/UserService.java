
public class UserService {
	public User createUser(String[] info) {
		User user = new User();
		user.setUsername(info[0]);
		user.setPassword(info[1]);
		user.setName(info[2]);
		return user;
	}
}
