package seb.jpa_example;

import java.util.Scanner;

import javax.persistence.EntityManager;

public class delete {

	public static void deleteone(EntityManager manager, Scanner type) {
		System.out.println("Was möchten Sie löschen?");
		System.out.println("Das sind Ihre Wahlmöglicheiten:");
		System.out.println("bestellung_artikel, bestellung, kunde, adresse, artikel");
		String type1 = type.nextLine();
		System.out.println("Sie möchten " + type1 + " löschen");
		type.close();

		if (type1.equals("bestellung_artikel")) {
			long id;

			System.out.println("Bitte die ID der Bestellung_Artikel");
			id = Integer.parseInt(type.nextLine());

			Bestellung_Artikel b = manager.find(Bestellung_Artikel.class, id);
			manager.getTransaction().begin();
			manager.remove(b);
			manager.getTransaction().commit();

		} else if (type1.equals("bestellung")) {
			long id;

			System.out.println("Bitte die ID der Bestellung");
			id = Integer.parseInt(type.nextLine());

			Bestellung_v3 b = manager.find(Bestellung_v3.class, id);
			manager.getTransaction().begin();
			manager.remove(b);
			manager.getTransaction().commit();

		} else if (type1.equals("kunde")) {
			long id;

			System.out.println("Bitte die ID des Kunden");
			id = Integer.parseInt(type.nextLine());

			Kunde k = manager.find(Kunde.class, id);
			manager.getTransaction().begin();
			manager.remove(k);
			manager.getTransaction().commit();

		} else if (type1.equals("adresse")) {
			long id;

			System.out.println("Bitte die ID der Adresse");
			id = Integer.parseInt(type.nextLine());

			Adresse a = manager.find(Adresse.class, id);
			manager.getTransaction().begin();
			manager.remove(a);
			manager.getTransaction().commit();

		} else if (type1.equals("artikel")) {
			long id;

			System.out.println("Bitte die ID des Artkels");
			id = Integer.parseInt(type.nextLine());

			Artikel a = manager.find(Artikel.class, id);
			manager.getTransaction().begin();
			manager.remove(a);
			manager.getTransaction().commit();

		}
	}

}
