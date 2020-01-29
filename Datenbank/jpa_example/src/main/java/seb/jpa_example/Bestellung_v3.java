package seb.jpa_example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
	@ManyToOne
	private Kunde Kunde;
	@Setter
	@Getter
	@ManyToOne
	private Adresse Adresse_Rechnung;
	@Setter
	@Getter
	@ManyToOne
	private Adresse Adresse_Liefer;

	public Bestellung_v3() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bestellung_v3(Kunde kunde, Adresse adresse_Rechnung, Adresse adresse_Liefer) {
		super();
		Kunde = kunde;
		Adresse_Rechnung = adresse_Rechnung;
		Adresse_Liefer = adresse_Liefer;
	}

	@Override
	public String toString() {
		return "Bestellung_v3 [id=" + id + ",\n Kunde=" + Kunde + ",\n Adresse_Rechnung=" + Adresse_Rechnung
				+ ",\n Adresse_Liefer=" + Adresse_Liefer + "]\n";
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public Kunde getKunde() {
		return Kunde;
	}

	public void setKunde(Kunde kunde) {
		Kunde = kunde;
	}

	public Adresse getAdresse_Rechnung() {
		return Adresse_Rechnung;
	}

	public void setAdresse_Rechnung(Adresse adresse_Rechnung) {
		Adresse_Rechnung = adresse_Rechnung;
	}

	public Adresse getAdresse_Liefer() {
		return Adresse_Liefer;
	}

	public void setAdresse_Liefer(Adresse adresse_Liefer) {
		Adresse_Liefer = adresse_Liefer;
	}
	
	
}
