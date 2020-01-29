package seb.jpa_example;

import java.util.Scanner;

import javax.persistence.EntityManager;

public class read {

	public static void readone(EntityManager manager, Scanner type) {
		System.out.println("Was möchten Sie auslesen?");
		System.out.println("Das sind Ihre Wahlmöglicheiten:");
		System.out.println("bestellung_artikel, bestellung, kunde, adresse, artikel");
		String type1 = type.nextLine();
		System.out.println("Sie möchten " + type1 + " auslesen");

		if (type1.equals("bestellung_artikel")) {
			long id;

			System.out.println("Bitte die ID der Bestellung_Artikel");
			id = Integer.parseInt(type.nextLine());

			Bestellung_Artikel b = manager.find(Bestellung_Artikel.class, id);
			System.out.println(b.toString());
		} else if (type1.equals("bestellung")) {
			long id;

			System.out.println("Bitte die ID der Bestellung");
			id = Integer.parseInt(type.nextLine());

			Bestellung_v3 b = manager.find(Bestellung_v3.class, id);
			System.out.println(b.toString());
		} else if (type1.equals("kunde")) {
			long id;

			System.out.println("Bitte die ID des Kunden");
			id = Integer.parseInt(type.nextLine());

			Kunde k = manager.find(Kunde.class, id);
			System.out.println(k.toString());
		} else if (type1.equals("adresse")) {
			long id;

			System.out.println("Bitte die ID der Adresse");
			id = Integer.parseInt(type.nextLine());

			Adresse a = manager.find(Adresse.class, id);
			System.out.println(a.toString());
		} else if (type1.equals("artikel")) {
			long id;

			System.out.println("Bitte die ID des Artikels");
			id = Integer.parseInt(type.nextLine());

			Artikel a = manager.find(Artikel.class, id);
			System.out.println(a.toString());
		}
	}
	
	// ---

	public static Bestellung_Artikel readbestellungartikel(EntityManager manager, Scanner type) {
		long id;

		System.out.println("Bitte die ID der Bestellung_Artikel");
		id = Integer.parseInt(type.nextLine());

		Bestellung_Artikel b = manager.find(Bestellung_Artikel.class, id);
		System.out.println(b.toString());
		return b;
	}

	public static Bestellung_v3 readbestellung(EntityManager manager, Scanner type) {
		long id;

		System.out.println("Bitte die ID der Bestellung");
		id = Integer.parseInt(type.nextLine());

		Bestellung_v3 b = manager.find(Bestellung_v3.class, id);
		System.out.println(b.toString());
		return b;
	}

	public static Kunde readkunde(EntityManager manager, Scanner type) {
		long id;

		System.out.println("Bitte die ID des Kunden");
		id = Integer.parseInt(type.nextLine());

		Kunde k = manager.find(Kunde.class, id);
		System.out.println(k.toString());
		return k;
	}

	public static Adresse readadresse(EntityManager manager, Scanner type) {
		long id;

		System.out.println("Bitte die ID der Adresse");
		id = Integer.parseInt(type.nextLine());

		Adresse a = manager.find(Adresse.class, id);
		System.out.println(a.toString());
		return a;
	}

	public static Artikel readartikel(EntityManager manager, Scanner type) {
		long id;

		System.out.println("Bitte die ID des Artikels");
		id = Integer.parseInt(type.nextLine());

		Artikel a = manager.find(Artikel.class, id);
		System.out.println(a.toString());
		return a;
	}

}
