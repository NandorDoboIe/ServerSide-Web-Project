
public class User {
	private int id;
	private String name;
	private String password;

	public User(int id, String n, String p) {
		this.id = id;
		this.name=n;
		this.password=p;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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
