package seb.jpa_example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	@ManyToOne
	private Bestellung_v3 Bestellung;
	@Setter
	@Getter
	@ManyToOne
	private Artikel Artikel;
	@Setter
	@Getter
	private int Menge;
	
	public Bestellung_Artikel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bestellung_Artikel(Bestellung_v3 bestellung, Artikel artikel, int menge) {
		super();
		Bestellung = bestellung;
		Artikel = artikel;
		Menge = menge;
	}

	@Override
	public String toString() {
		return "Bestellung_Artikel [id=" + id + ",\n Bestellung=" + Bestellung + ",\n Artikel=" + Artikel + ",\n Menge="
				+ Menge + "]\n";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Bestellung_v3 getBestellung() {
		return Bestellung;
	}

	public void setBestellung(Bestellung_v3 bestellung) {
		Bestellung = bestellung;
	}

	public Artikel getArtikel() {
		return Artikel;
	}

	public void setArtikel(Artikel artikel) {
		Artikel = artikel;
	}

	public int getMenge() {
		return Menge;
	}

	public void setMenge(int menge) {
		Menge = menge;
	}
	
	
}
