import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class create {
	static Connection c = null;
	
	public static void docreate() {
		Scanner type = new Scanner(System.in);
		System.out.println("Was möchten Sie hinzufügen?");
		String type1 = type.nextLine();
		System.out.println("Sie wollen hinzufügen: " + type1);
		type.close();

		if (type1.equals("kunde")) {
			createKunde();
		} else if (type1.equals("bestellung_artikel")) {
			createBestellung_artikel();
		} else if (type1.equals("artikel")) {
			createArtikel();
		} else if (type1.equals("bestellung_v3")) {
			createBestellung_v3();
		} else if (type1.equals("adresse")) {
			createAdresse();
		}

	}
	
	public static void createKunde() {
		Scanner scan = new Scanner(System.in);
		System.out.println("titelV?");
		String titelV = scan.nextLine();
		System.out.println("Vorname?");
		String vorname = scan.nextLine();
		System.out.println("Nachname?");
		String nachname = scan.nextLine();
		System.out.println("titelN?");
		String titelN = scan.nextLine();
		scan.close();

		String sql = "INSERT INTO kunde(titelV, vorname, nachname, titelN) values(?,?,?,?)";
		PreparedStatement stmt;
		try {
			c = (Connection) database.getConnection();
			stmt = c.prepareStatement(sql);
			stmt.setString(1, titelV);
			stmt.setString(2, vorname);
			stmt.setString(3, nachname);
			stmt.setString(4, titelN);
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Vorgang abgeschlossen");
	}

	public static void createAdresse() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Stadt?");
		String stadt = scan.nextLine();
		System.out.println("Strasse?");
		String strasse = scan.nextLine();
		System.out.println("PLZ?");
		String PLZ = scan.nextLine();
		System.out.println("Hausnummer?");
		String Hnr = scan.nextLine();
		scan.close();

		String sql = "INSERT INTO adresse(stadt, strasse, PLZ, Hnr) values(?,?,?,?)";
		PreparedStatement stmt;
		try {
			c = (Connection) database.getConnection();
			stmt = c.prepareStatement(sql);
			stmt.setString(1, stadt);
			stmt.setString(2, strasse);
			stmt.setString(3, PLZ);
			stmt.setString(4, Hnr);
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Vorgang abgeschlossen");
	}

	public static void createArtikel() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Artikelname?");
		String artikelname = scan.nextLine();
		System.out.println("Preis?");
		String preis = scan.nextLine();
		scan.close();

		String sql = "INSERT INTO artikel(artikelname, preis) values(?,?)";
		PreparedStatement stmt;
		try {
			c = (Connection) database.getConnection();
			stmt = c.prepareStatement(sql);
			stmt.setString(1, artikelname);
			stmt.setString(2, preis);
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Vorgang abgeschlossen");
	}

	public static void createBestellung_v3() {
		Scanner scan = new Scanner(System.in);
		System.out.println("ID des Kunden?");
		String kunde_id = scan.nextLine();
		System.out.println("ID der Lieferadresse?");
		String adresse_liefer_id = scan.nextLine();
		System.out.println("Ist die Rechnungsadresse identisch? (ja/nein)");
		String rr = scan.nextLine();
		String adresse_rechnung_id = null;
		if (rr.equals("ja")) {
			adresse_rechnung_id = adresse_liefer_id;
		} else if (rr.equals("nein")) {
			System.out.println("ID der Rechnunsadresse?");
			adresse_rechnung_id = scan.nextLine();
		}
		scan.close();

		/*
		 * String sql1 =
		 * "SELECT kunde WHERE vorname = vname AND WHERE nachnamen = nname";
		 * PreparedStatement stmt1; c = (Connection) getInstance(); stmt1 =
		 * c.prepareStatement(sql1);
		 * 
		 * 
		 * 
		 * String sql2 = "SELECT * FROM kunde WHERE vorname = ? AND nachname =?";
		 * PreparedStatement ps = c.prepareStatement(sql2); ps.setString(1, vname);
		 * ps.setString(2, nname); ResultSet rs = ps.executeQuery();
		 */

		String sql = "INSERT INTO bestellung_v3(kunde_id, adresse_rechnung_id, adresse_liefer_id) values(?,?,?)";
		PreparedStatement stmt;
		try {
			c = (Connection) database.getConnection();
			stmt = c.prepareStatement(sql);
			stmt.setString(1, kunde_id);
			stmt.setString(2, adresse_rechnung_id);
			stmt.setString(3, adresse_liefer_id);
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Vorgang abgeschlossen");
	}

	public static void createBestellung_artikel() {
		Scanner scan = new Scanner(System.in);
		System.out.println("ID der Bestellung?");
		String bestell_id = scan.nextLine();
		System.out.println("ID des Artikels?");
		String artikel_id = scan.nextLine();
		System.out.println("Menge?");
		String menge = scan.nextLine();
		scan.close();

		String sql = "INSERT INTO bestellung_artikel(bestell_id, artikel_id, menge) values(?,?,?)";
		PreparedStatement stmt;
		try {
			c = (Connection) database.getConnection();
			stmt = c.prepareStatement(sql);
			stmt.setString(1, bestell_id);
			stmt.setString(2, artikel_id);
			stmt.setString(3, menge);
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Vorgang abgeschlossen");
	}
	
}
