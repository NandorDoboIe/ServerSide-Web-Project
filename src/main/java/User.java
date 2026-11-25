
public class User {
private int id;
private String name;
private String address;

public User(String n, String a) {
	this.name=n;
	this.address=a;
}


public String getAddress() {
	return address;
}


public void setAddress(String address) {
	this.address = address;
}


public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
}
