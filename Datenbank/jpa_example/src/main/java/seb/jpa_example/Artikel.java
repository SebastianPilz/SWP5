package seb.jpa_example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Artikel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter
	@Getter
	private long id;
	@Setter
	@Getter
	private String Name;
	@Setter
	@Getter
	private double Preis;
	public Artikel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Artikel(String name, double preis) {
		super();
		Name = name;
		Preis = preis;
	}
	
}
