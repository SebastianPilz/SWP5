package seb.jpa_example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
	public static void main(String[] args) {
		EntityManagerFactory f = Persistence.createEntityManagerFactory("MyUnit");
		EntityManager manager = f.createEntityManager();
		
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
		
		
		
		
		Person p1 = manager.find(Person.class, 1L);
		
		System.out.println(p1);
		
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
