import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class database {
	private static database instance;
	private static Connection c = null;

	private database() {

		/**
		 * try (Connection conn = DriverManager.getConnection(
		 * "jdbc:postgresql://127.0.0.1:5432/Aufgabe01", "postgres", "admin")) {
		 * 
		 * if (conn != null) { System.out.println("Connected to the database!"); } else
		 * { System.out.println("Failed to make connection!"); }
		 * 
		 * } catch (SQLException e) { System.err.format("SQL State: %s\n%s",
		 * e.getSQLState(), e.getMessage()); } catch (Exception e) {
		 * e.printStackTrace(); }
		 **/

		try {
			c = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/Aufgabe01", "postgres", "admin");

			if (c != null) {
				System.out.println("Connected to the database!");
			} else {
				System.out.println("Failed to make connection!");
			}
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			e.printStackTrace();
		}
	}

	public static database getInstance() {
		if (instance == null) {
			instance = new database();
		}
		return instance;
	}
	
	public static Connection getConnection() {
		if (instance == null) {
			instance = new database();
		}
		if (c == null) {
			try {
				c = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/Aufgabe01", "postgres", "admin");

				if (c != null) {
					System.out.println("Connected to the database!");
				} else {
					System.out.println("Failed to make connection!");
				}
			} catch (SQLException e) {
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
				e.printStackTrace();
			}
		}
		return c;
	}

	public static void action() throws SQLException {
		Scanner type = new Scanner(System.in);
		System.out.println("Was möchten Sie machen?");
		String type1 = type.nextLine();
		System.out.println("Sie wollen: " + type1);
		type.close();
		
		
		if (type1.equals("create")) {
			create.docreate();
		} else if (type1.equals("read")) {
			read.doread();
		} else if (type1.equals("update")) {
			update.doupdate();
		} else if (type1.equals("delete")) {
			delete.dodelete();
		}
	}


	

	

	
}
