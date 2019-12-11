package seb.jpa_example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Bestellung_v3 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter
	@Getter
	private long id;
	@Setter
	@Getter
	private int Kunde_id;
	@Setter
	@Getter
	private int Adresse_Rechnung_id;
	@Setter
	@Getter
	private int Adresse_Liefer_id;

	public Bestellung_v3() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bestellung_v3(int kunde_id, int adresse_Rechnung_id, int adresse_Liefer_id) {
		super();
		Kunde_id = kunde_id;
		Adresse_Rechnung_id = adresse_Rechnung_id;
		Adresse_Liefer_id = adresse_Liefer_id;
	}

}
