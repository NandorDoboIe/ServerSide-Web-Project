import java.util.ArrayList;

public class Tester {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		ArrayList<User> userList = UserDAO.instance.list();

		for(User u : userList) {
			System.out.println(u.getName()  + " "+ u.getAddress());
		}

		User u1 = new User("Rob", "Galway");

		UserDAO.instance.save(u1);

		userList = UserDAO.instance.list();
		for(User u : userList) {
			System.out.println(u.getName()  + " "+ u.getAddress());
		}
		System.out.println(userList.size());

	}

}
