

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.security.crypto.bcrypt.*;

public class database {

	private static database instance;
	private Connection con = null;
	private String driver;
	private static String user;
	private static String pwd;
	private static String path;

	private  DataSource dataSource = null;
	public void init(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Connection getConnection() throws SQLException {
		Connection con = dataSource.getConnection();
		return con;
	}

	public void releaseConnection(Connection con) {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static database getInstance() {
		if (instance == null) {
			instance = new database();
		}
		return instance;
	}

	public void addUser(Connection con, String n, String p) {
		String sql = "INSERT INTO user(name, password) values(?,?)";
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, n);
			stmt.setString(2, BCrypt.hashpw(p, BCrypt.gensalt()));
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public User checkUser(Connection con, String n, String p) throws SQLException {

		String sql = "SELECT * FROM user WHERE name =?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, n);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			User user = new User();
			user.setUserid(rs.getInt("userid"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			if (BCrypt.checkpw(p, user.getPassword()) == true) {
				return user;
			}
		}
		return null;
	}
}
