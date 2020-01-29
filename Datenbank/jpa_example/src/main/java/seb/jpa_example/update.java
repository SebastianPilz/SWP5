package seb.jpa_example;

import java.util.Scanner;

import javax.persistence.EntityManager;

public class update {

	public static void updateone(EntityManager manager, String type1, Scanner type) {

		if (type1.equals("no")) {
			System.out.println("Was möchten Sie aktualisieren?");
			System.out.println("Das sind Ihre Wahlmöglicheiten:");
			System.out.println("bestellung_artikel, bestellung, kunde, adresse, artikel");
			type1 = type.nextLine();
			System.out.println("Sie möchten " + type1 + " aktualisieren");
		}
		if (type1.equals("bestellung_artikel")) {
			// --- Bestellung Artikel ---
			Bestellung_Artikel b;
			String newa;
			int menge;

			b = read.readbestellungartikel(manager, type);

			System.out.println("Was möchten Sie ändern?");

			// Bestellung

			System.out.println("Bestellung?");
			newa = type.nextLine();
			if (newa.equals("ja")) {
				updateone(manager, "bestellung", type);
			}

			// Artikel

			System.out.println("Artikel?");
			newa = type.nextLine();
			if (newa.equals("ja")) {
				updateone(manager, "artikel", type);
			}

			// Menge

			System.out.println("Menge?");
			newa = type.nextLine();
			if (newa.equals("ja")) {
				System.out.println("neue Menge?");
				menge = Integer.parseInt(type.nextLine());
				b.setMenge(menge);
			}

			manager.getTransaction().begin();
			manager.getTransaction().commit();
		} else if (type1.equals("bestellung")) {
			// --- Bestellung ---
			Bestellung_v3 b;
			String newa;

			b = read.readbestellung(manager, type);

			System.out.println("Was möchten Sie ändern?");

			// Kunde

			System.out.println("Kunde?");
			newa = type.nextLine();
			if (newa.equals("ja")) {
				updateone(manager, "kunde", type);
			}

			System.out.println("Rechnungsadresse?");
			newa = type.nextLine();
			if (newa.equals("ja")) {
				updateone(manager, "adresse", type);
			}

			System.out.println("Lieferadresse?");
			newa = type.nextLine();
			if (newa.equals("ja")) {
				updateone(manager, "adresse", type);
			}
			manager.getTransaction().begin();
			manager.getTransaction().commit();
		} else if (type1.equals("kunde")) {
			// --- Kunde ---
			Kunde k;
			String titelv;
			String vorname;
			String nachname;
			String titeln;
			String newa;

			k = read.readkunde(manager, type);

			System.out.println("Was möchten Sie ändern?");

			// vorgestellter Titel

			System.out.println("vorgestellter Titel?");
			newa = type.nextLine();

			if (newa.equals("ja")) {
				System.out.println("neuer vorgestellter Titel?");
				titelv = type.nextLine();
				k.setTitelV(titelv);
			}

			// Vorname

			System.out.println("Vorname?");
			newa = type.nextLine();

			if (newa.equals("ja")) {
				System.out.println("neuer Vorname?");
				vorname = type.nextLine();
				k.setVorname(vorname);
			}

			// Nachname

			System.out.println("Nachname?");
			newa = type.nextLine();

			if (newa.equals("ja")) {
				System.out.println("neuer Nachname?");
				nachname = type.nextLine();
				k.setVorname(nachname);
			}

			// nachgestellter Titel

			System.out.println("nachgestellter Titel?");
			newa = type.nextLine();

			if (newa.equals("ja")) {
				System.out.println("neuer nachgestellter Titel?");
				titeln = type.nextLine();
				k.setVorname(titeln);
			}

			manager.getTransaction().begin();
			manager.getTransaction().commit();
		} else if (type1.equals("adresse")) {
			// --- Adresse ---
			Adresse a;
			String stadt;
			String strasse;
			int plz;
			int hnr;
			String newa;

			a = read.readadresse(manager, type);

			System.out.println("Was möchten Sie ändern?");

			// Stadt

			System.out.println("Stadt?");
			newa = type.nextLine();

			if (newa.equals("ja")) {
				System.out.println("neue Stadt?");
				stadt = type.nextLine();
				a.setStadt(stadt);
			}

			// Strasse

			System.out.println("Strasse?");
			newa = type.nextLine();

			if (newa.equals("ja")) {
				System.out.println("neue Strasse?");
				strasse = type.nextLine();
				a.setStrasse(strasse);
			}

			// PLZ

			System.out.println("PLZ?");
			newa = type.nextLine();

			if (newa.equals("ja")) {
				System.out.println("neue PLZ?");
				plz = Integer.parseInt(type.nextLine());
				a.setPLZ(plz);
			}

			// Hausnummer

			System.out.println("Hausnummer?");
			newa = type.nextLine();

			if (newa.equals("ja")) {
				System.out.println("neue Hausnummer?");
				hnr = Integer.parseInt(type.nextLine());
				a.setHnr(hnr);
			}

			manager.getTransaction().begin();
			manager.getTransaction().commit();
		} else if (type1.equals("artikel")) {
			// --- Artikel ---
			Artikel a;
			String name;
			double preis;
			String newa;

			a = read.readartikel(manager, type);

			// Name

			System.out.println("Was möchten Sie ändern?");
			System.out.println("Name?");
			newa = type.nextLine();

			if (newa.equals("ja")) {
				System.out.println("neuer Name?");
				name = type.nextLine();
				a.setName(name);
			}

			// Preis

			System.out.println("Preis?");
			newa = type.nextLine();

			if (newa.equals("ja")) {
				System.out.println("neuer Preis?");
				preis = Double.parseDouble(type.nextLine());
				a.setPreis(preis);
			}

			manager.getTransaction().begin();
			manager.getTransaction().commit();
		}
	}
}
