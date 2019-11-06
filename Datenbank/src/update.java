import java.sql.Connection;
import java.util.Scanner;

public class update {
	static Connection c = null;

	public static void doupdate() {
		Scanner type = new Scanner(System.in);
		System.out.println("Was möchten Sie hinzufügen?");
		String type1 = type.nextLine();
		System.out.println("Sie wollen hinzufügen: " + type1);
		type.close();

		if (type1.equals("kunde")) {
			updateKunde();
		} else if (type1.equals("bestellung_artikel")) {
			updateBestellung_artikel();
		} else if (type1.equals("artikel")) {
			updateArtikel();
		} else if (type1.equals("bestellung_v3")) {
			updateBestellung_v3();
		} else if (type1.equals("adresse")) {
			updateAdresse();
		}
	}

	public static void updateKunde() {

	}

	public static void updateArtikel() {

	}

	public static void updateAdresse() {

	}

	public static void updateBestellung_artikel() {

	}

	public static void updateBestellung_v3() {

	}
}
