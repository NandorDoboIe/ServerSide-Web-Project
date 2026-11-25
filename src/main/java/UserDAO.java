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
	
	public void save(User u) throws Exception {
		Connection c = getConnection();
		PreparedStatement psmt = c.prepareStatement(
				"insert into user (name, address) values(?,?)");
		psmt.setString(1, u.getName());
		psmt.setString(2, u.getAddress());
		psmt.executeUpdate();
	}
	
	public ArrayList<User> read() throws Exception{
		Connection c = getConnection();
		Statement stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM USER");
		
		users = new ArrayList();
		while (rs.next()) {
						
			User u = new User(rs.getString("name"), rs.getString("address"));
			users.add(u);
		}
		
		return users;
	}

	public void save(User u) throws Exception {
		Connection c = getConnection();
		PreparedStatement psmt = c.prepareStatement(
				"insert into user (name, address) values(?,?)");
		psmt.setString(1, u.getName());
		psmt.setString(2, u.getAddress());
		psmt.executeUpdate();
	}

	public void save(User u) throws Exception {
		Connection c = getConnection();
		PreparedStatement psmt = c.prepareStatement(
				"insert into user (name, address) values(?,?)");
		psmt.setString(1, u.getName());
		psmt.setString(2, u.getAddress());
		psmt.executeUpdate();
	}

	public void delete(User u) throws Exception{
		Connection c = getConnection;
		PreparedStatement psmt = c.prepareStatement(
			"DELETE "
		)
	}
}
