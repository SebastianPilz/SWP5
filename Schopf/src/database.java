

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import Web.L1;

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
	
//	public void init(String driver, String user, String pwd, String path) {
//		try {
//
//			Class.forName(driver);
//			this.driver = driver;
//			this.user = user;
//			this.pwd = pwd;
//			this.path = path;
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

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

	public void addUser(Connection con, String u, String p) {
		String sql = "INSERT INTO user(username, password) values(?,?)";
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, u);
			stmt.setString(2, p);
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public User checkUser(Connection con, String u, String p) throws SQLException {

		String sql = "SELECT * FROM user WHERE username =? AND password =?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, u);
		ps.setString(2, p);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			User user = new User();
			user.setUserid(rs.getInt("userid"));
			user.setUsername(rs.getString("username"));
			return user;
		}
		return null;
	}

	public static ArrayList<Post> getPosts(Connection con, int topicid) throws SQLException {

		ArrayList<Post> p = new ArrayList<Post>();

		String sql = "SELECT * FROM post WHERE topicid = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, topicid);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Post post = new Post();
			post.setPostid(rs.getInt("postid"));
			post.setTopicid(rs.getInt("topicid"));
			post.setHeadline(rs.getString("headline"));
			post.setShorty(rs.getString("shorty"));
			post.setMsg(rs.getString("msg"));
			post.setUserid(rs.getInt("userid"));
			p.add(post);
		}
		return p;
	}

	public void addPost(Connection con, int postid, String msg, int userid) {
		String sql = "INSERT INTO post(postid, msg, userid) values(?,?,?)";
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, postid);
			stmt.setString(2, msg);
			stmt.setInt(3, userid);
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static ArrayList<Topic> getTopics(Connection con) throws SQLException {

		ArrayList<Topic> t = new ArrayList<Topic>();

		String sql = "SELECT * FROM topic";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Topic post = new Topic();
			post.setTopicid(rs.getInt("topicid"));
			post.setTopic(rs.getString("topic"));
			t.add(post);
		}
		return t;
	}

	public static ArrayList<Comment> getComments(Connection con, int postid) throws SQLException {

		ArrayList<Comment> cc = new ArrayList<Comment>();

		String sql = "SELECT * FROM comments WHERE postid = ? AND ebene = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, postid);
		ps.setInt(2, 0);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Comment c = new Comment();
			c.setCid(rs.getInt("cid"));
			c.setMsg(rs.getString("msg"));
			c.setPcid(rs.getInt("pcid"));
			c.setPostid(rs.getInt("postid"));
			c.setCreatedby(rs.getString("createdby"));
			c.setEbene(rs.getString("ebene"));
			c.setNbrchilds(getNbrchilds(con, c.getCid()));
			cc.add(c);
		}

		return cc;
	}
	
	public static ArrayList<Comment> getFurtherComments(Connection con, int cid) throws SQLException {

		ArrayList<Comment> cc = new ArrayList<Comment>();

		String sql = "SELECT * FROM comments WHERE pcid = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, cid);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Comment c = new Comment();
			c.setCid(rs.getInt("cid"));
			c.setMsg(rs.getString("msg"));
			c.setPcid(rs.getInt("pcid"));
			c.setPostid(rs.getInt("postid"));
			c.setCreatedby(rs.getString("createdby"));
			c.setEbene(rs.getString("ebene"));
			c.setNbrchilds(getNbrchilds(con, c.getCid()));
			cc.add(c);
			
		}

		return cc;
	}
	
	public static int getNbrchilds(Connection con, int cid) throws SQLException {
		String sql = "select c.*, (select count(*) from comments c2 where c2.pcid = c.cid) as nbrchilds from comments c where cid = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, cid);
		ResultSet rs = ps.executeQuery();
		int result = 0;

		while (rs.next()) {
			
			result = rs.getInt("nbrchilds");
		}

		return result;
	}

}
