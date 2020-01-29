package seb.jpa_example;

import java.util.Scanner;

import javax.persistence.EntityManager;

public class create {

	public static void createone(EntityManager manager, String type1, Scanner type) {

		if (type1.equals("no")) {

			System.out.println("Was möchten Sie erstellen?");
			System.out.println("Das sind Ihre Wahlmöglicheiten:");
			System.out.println("bestellung_artikel, bestellung, kunde, adresse, artikel");
			type1 = type.nextLine();

			System.out.println("Sie möchten " + type1 + " erstellen");

		}
		if (type1.equals("bestellung_artikel")) {
			// --- Bestellung_Artikel ---
			Bestellung_v3 bestellung = null;
			Artikel artikel = null;
			int menge = 0;

			// Bestellung

			System.out.println("Bestehende Bestellung?");
			String newa = type.nextLine();

			if (newa.equals("ja")) {
				bestellung = read.readbestellung(manager, type);
			} else if (newa.equals("nein")) {
				createone(manager, "bestellung", type);
				bestellung = read.readbestellung(manager, type);
			}

			// Artikel

			System.out.println("Bestehender Artikel?");
			String newa1 = type.nextLine();

			if (newa1.equals("ja")) {
				artikel = read.readartikel(manager, type);
			} else if (newa1.equals("nein")) {
				createone(manager, "artikel", type);
				artikel = read.readartikel(manager, type);
			}

			// Menge

			System.out.println("Wie viele Artikel?");
			menge = Integer.parseInt(type.nextLine());

			// Speichern

			Bestellung_Artikel b = new Bestellung_Artikel(bestellung, artikel, menge);
			manager.getTransaction().begin();
			manager.persist(b);
			manager.getTransaction().commit();

		} else if (type1.equals("bestellung")) {
			// --- Bestellung ---
			Kunde kunde = null;
			Adresse r = null;
			Adresse l = null;

			// Kunde

			System.out.println("Bestehender Kunde?");
			String newa = type.nextLine();

			if (newa.equals("ja")) {
				kunde = read.readkunde(manager, type);
			} else if (newa.equals("nein")) {
				createone(manager, "kunde", type);
				kunde = read.readkunde(manager, type);
			}

			// Rechnungsadresse

			System.out.println("Bestehende Rechnungsadresse?");
			newa = type.nextLine();

			if (newa.equals("ja")) {
				r = read.readadresse(manager, type);
			} else if (newa.equals("nein")) {
				createone(manager, "adresse", type);
				r = read.readadresse(manager, type);
			}

			// Lieferadresse

			System.out.println("Rechnungsadresse gleich wie Lieferadresse?");
			newa = type.nextLine();

			if (newa.equals("ja")) {
				l = r;
			} else if (newa.equals("nein")) {
				System.out.println("Bestehende Lieferadresse?");
				newa = type.nextLine();

				if (newa.equals("ja")) {
					l = read.readadresse(manager, type);
				} else if (newa.equals("nein")) {
					createone(manager, "adresse", type);
					l = read.readadresse(manager, type);
				}
			}

			// Speichern

			Bestellung_v3 b = new Bestellung_v3(kunde, r, l);
			manager.getTransaction().begin();
			manager.persist(b);
			manager.getTransaction().commit();

		} else if (type1.equals("kunde")) {
			// --- Kunde ---
			String titelv;
			String vorname;
			String nachname;
			String titeln;

			// vorgestellter Titel

			System.out.println("vorgestellter Titel?");
			titelv = type.nextLine();
			// Vorname
			System.out.println("Vorname?");
			vorname = type.nextLine();
			// Nachname
			System.out.println("Nachname?");
			nachname = type.nextLine();
			// nachstehender Titel
			System.out.println("nachstehender Titel?");
			titeln = type.nextLine();

			// Speichern

			Kunde k = new Kunde(titelv, vorname, nachname, titeln);
			manager.getTransaction().begin();
			manager.persist(k);
			manager.getTransaction().commit();

		} else if (type1.equals("adresse")) {
			// --- Adresse ---
			String stadt;
			String strasse;
			int plz;
			int hnr;

			// Stadt

			System.out.println("welche Stadt?");
			stadt = type.nextLine();
			// Strasse
			System.out.println("welche Strasse?");
			strasse = type.nextLine();
			// PLZ
			System.out.println("PLZ?");
			plz = Integer.parseInt(type.nextLine());
			// Hausnummer
			System.out.println("Hausnummer?");
			hnr = Integer.parseInt(type.nextLine());

			// Speichern

			Adresse a = new Adresse(stadt, strasse, plz, hnr);
			manager.getTransaction().begin();
			manager.persist(a);
			manager.getTransaction().commit();

		} else if (type1.equals("artikel")) {
			// --- Artikel ---
			String artikel;
			double preis;

			// Name

			System.out.println("Name?");
			artikel = type.nextLine();
			// Preis
			System.out.println("Preis?");
			preis = Double.parseDouble(type.nextLine());

			// Speichern

			Artikel a = new Artikel(artikel, preis);
			manager.getTransaction().begin();
			manager.persist(a);
			manager.getTransaction().commit();
		}
	}
}
