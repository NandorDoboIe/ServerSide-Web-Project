import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;

public enum UserDAO {
instance;
	ArrayList<User> users;

	public Connection getConnection() throws Exception{
		Class.forName("org.hsqldb.jdbcDriver");
		Connection con;
		con = DriverManager.getConnection(
				"jdbc:hsqldb:hsql://localhost/oneDB",
				"sa",""
				);
		return con;

	}
	
	public void save(User user) throws Exception {
		Connection c = getConnection();
		PreparedStatement psmt = c.prepareStatement(
				"insert into user (name, password) values(?,?)");
		psmt.setString(1, user.getName());
		psmt.setString(2, user.getPassword());
		psmt.executeUpdate();
	}
	
	public ArrayList<User> read() throws Exception{
		Connection c = getConnection();
		Statement stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM USER");
		
		users = new ArrayList();
		while (rs.next()) {
						
			User u = new User(rs.getInt("id"), rs.getString("name"), rs.getString("password"));
			users.add(u);
		}
		
		return users;
	}

	public User readSpecificUser(User user) throws Exception{
		Connection c = getConnection();
		Statement stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM USER WHERE ID="+user.getId());
		User newUser = new User(rs.getInt("id"),rs.getString("name"), rs.getString("password"));
		
		return newUser;
	}

	public boolean delete(User user) throws Exception{
		Connection c = getConnection();
		PreparedStatement psmt = c.prepareStatement(
			"DELETE FROM USER WHERE ID="+user.getId()
		);
		psmt.executeUpdate();

		int rowsAffected = psmt.executeUpdate();

		if (rowsAffected == 0) {
			System.out.println("No User with id " + user.getId() + " exists");
			return false;
		}
		return true;
	}

	public boolean update(User user) throws Exception{
		readSpecificUser(user);
		
		Connection  c = getConnection();
		PreparedStatement pstm = c.prepareStatement(
			"UPDATE USER SET name="+ user.getName() +", PASSWORD=" + user.getPassword() +" WHERE ID="+user.getId()
		);
		

		int rowsAffected = pstm.executeUpdate();

		if (rowsAffected == 0) {
			System.out.println("No User with id " + user.getId() + " exists");
			return false;
		}
		return true;
	}
}
