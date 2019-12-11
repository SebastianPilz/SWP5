package seb.jpa_example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Bestellung_Artikel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter
	@Getter
	private long id;
	@Setter
	@Getter
	private int Artikel_id;
	@Setter
	@Getter
	private int Menge;
	
	public Bestellung_Artikel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bestellung_Artikel(int artikel_id, int menge) {
		super();
		Artikel_id = artikel_id;
		Menge = menge;
	}
	
	
}
