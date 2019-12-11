package seb.jpa_example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Adresse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter
	@Getter
	private long id;
	@Setter
	@Getter
	private String Stadt;
	@Setter
	@Getter
	private String Strasse;
	@Setter
	@Getter
	private int PLZ;
	@Setter
	@Getter
	private int Hnr;

	public Adresse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Adresse(String stadt, String strasse, int pLZ, int hnr) {
		super();
		Stadt = stadt;
		Strasse = strasse;
		PLZ = pLZ;
		Hnr = hnr;
	}

}
