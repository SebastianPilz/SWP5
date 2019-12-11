import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class read {
	static Connection c = null;

	public static void doread() throws SQLException {
		Scanner type = new Scanner(System.in);
		System.out.println("Wo wollen Sie suchen -- (table)?");
		String type1 = type.nextLine();
		System.out.println("Sie wollen suchen: " + type1);
		type.close();
		
		if (type1.equals("kunde")) {
			readKunde();
		} else if (type1.equals("bestellung_artikel")) {
			readBestellung_artikel();
		} else if (type1.equals("artikel")) {
			readArtikel();
		} else if (type1.equals("bestellung_v3")) {
			readBestellung_v3();
		} else if (type1.equals("adresse")) {
			readAdresse();
		}

	}

	public static void readKunde() throws SQLException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Vorname?");
		String vorname = scan.nextLine();
		System.out.println("Nachname?");
		String nachname = scan.nextLine();
		scan.close();
		
		c = (Connection) database.getConnection();
		String sql = "SELECT * FROM kunde WHERE vorname = ? AND nachname =?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, vorname);
		ps.setString(2, nachname);
		ResultSet rs = ps.executeQuery();
		System.out.println(rs.next());
		
		System.out.println("Vorgang abgeschlossen");
	}

	public static void readArtikel() throws SQLException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Artikelname?");
		String artikelname = scan.nextLine();
		System.out.println("Preis?");
		String preis = scan.nextLine();
		scan.close();
		
		c = (Connection) database.getConnection();
		String sql = "SELECT * FROM artikel WHERE artikelname = ? AND preis =?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, artikelname);
		ps.setString(2, preis);
		ResultSet rs = ps.executeQuery();
		System.out.println(rs.next());
		
		System.out.println("Vorgang abgeschlossen");
	}

	public static void readAdresse() throws SQLException {
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
		
		c = (Connection) database.getConnection();
		String sql = "SELECT * FROM adresse WHERE stadt = ? AND strasse = ? AND PLZ = ? AND Hnr = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, stadt);
		ps.setString(2, strasse);
		ps.setString(3, PLZ);
		ps.setString(4, Hnr);
		ResultSet rs = ps.executeQuery();
		System.out.println(rs.next());
		
		System.out.println("Vorgang abgeschlossen");
	}

	public static void readBestellung_artikel() throws SQLException {
		Scanner scan = new Scanner(System.in);
		System.out.println("ID der Bestellung?");
		String bestell_id = scan.nextLine();
		System.out.println("ID des Artikels?");
		String artikel_id = scan.nextLine();
		System.out.println("Menge?");
		String menge = scan.nextLine();
		scan.close();
		
		c = (Connection) database.getConnection();
		String sql = "SELECT * FROM bestellung_artikel WHERE bestell_id = ? AND artikel_id = ? AND menge = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, bestell_id);
		ps.setString(2, artikel_id);
		ps.setString(3, menge);
		ResultSet rs = ps.executeQuery();
		System.out.println(rs.next());
		
		System.out.println("Vorgang abgeschlossen");
	}

	public static void readBestellung_v3() throws SQLException {
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
		
		c = (Connection) database.getConnection();
		String sql = "SELECT * FROM bestellung_v3 WHERE kunde_id = ? AND adresse_rechnung_id = ? AND adresse_liefer_id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, kunde_id);
		ps.setString(2, adresse_rechnung_id);
		ps.setString(3, adresse_liefer_id);
		ResultSet rs = ps.executeQuery();
		System.out.println(rs.next());
		
		System.out.println("Vorgang abgeschlossen");
	}

}
