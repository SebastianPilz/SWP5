import java.sql.Connection;
import java.util.Scanner;

public class delete {
	static Connection c = null;

	public static void dodelete() {
		Scanner type = new Scanner(System.in);
		System.out.println("Was möchten Sie hinzufügen?");
		String type1 = type.nextLine();
		System.out.println("Sie wollen hinzufügen: " + type1);
		type.close();

		if (type1.equals("kunde")) {
			deleteKunde();
		} else if (type1.equals("bestellung_artikel")) {
			deleteBestellung_artikel();
		} else if (type1.equals("artikel")) {
			deleteArtikel();
		} else if (type1.equals("bestellung_v3")) {
			deleteBestellung_v3();
		} else if (type1.equals("adresse")) {
			deleteAdresse();
		}

	}

	public static void deleteKunde() {

	}

	public static void deleteArtikel() {

	}

	public static void deleteAdresse() {

	}

	public static void deleteBestellung_artikel() {

	}

	public static void deleteBestellung_v3() {

	}

}
