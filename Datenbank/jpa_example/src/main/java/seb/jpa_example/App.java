package seb.jpa_example;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory f = Persistence.createEntityManagerFactory("MyUnit");
		EntityManager manager = f.createEntityManager();

		Scanner action = new Scanner(System.in);
		System.out.println("Was möchten Sie tun?");
		System.out.println("Das sind Ihre Wahlmöglicheiten:");
		System.out.println("create, read, update, delete");
		String actionstring = action.nextLine();
		System.out.println("Sie möchten: " + actionstring);
		

		if (actionstring.equals("create")) {
			create.createone(manager, "no", action);
		} else if (actionstring.equals("read")) {
			read.readone(manager, action);
		} else if (actionstring.equals("update")) {
			update.updateone(manager, "no", action);
		} else if (actionstring.equals("delete")) {
			delete.deleteone(manager, action);
		}
		
		action.close();
		
		
		// create

//		Person p = new Person(1, 18, "Seb", "PP");
//		Person p = new Person();
//		p.setAge(18);
//		p.setFirstName("Mario");
//		p.setLastName("JALOLEY");
//
//		manager.getTransaction().begin();
//		manager.persist(p);
//		manager.getTransaction().commit();

		// update

//		Person p = manager.find(Person.class, 2L);
//		System.out.println(p);
//		
//		p.setFirstName("Valtteri");
//		p.setLastName("Bottas");
//		p.setAge(77);
//		
//		Person p1 = manager.find(Person.class, 1L);
//		p1.setFirstName("George");
//		p1.setLastName("Russell");
//		p1.setAge(63);
//		
//		manager.getTransaction().begin();
//		manager.getTransaction().commit();

		// remove

//		Person p3 = manager.find(Person.class, 3L);
//		
//		manager.getTransaction().begin();
//		manager.remove(p3);
//		manager.getTransaction().commit();

//		Hobby h = new Hobby("Driving", 20, 12.40);
//		p1.setHobby(h);
//		
//		System.out.println("New Hobby - before persist");
//		System.out.println(h);
//		
//		manager.getTransaction().begin();
//		manager.persist(h);
//		manager.getTransaction().commit();
//		
//		System.out.println("New Hobby - before persist");
//		System.out.println(h);

	}
}
