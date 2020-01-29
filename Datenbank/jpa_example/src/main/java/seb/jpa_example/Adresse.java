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

	@Override
	public String toString() {
		return "Adresse [id=" + id + ",\n Stadt=" + Stadt + ",\n Strasse=" + Strasse + ",\n PLZ=" + PLZ + ",\n Hnr=" + Hnr
				+ "]\n";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStadt() {
		return Stadt;
	}

	public void setStadt(String stadt) {
		Stadt = stadt;
	}

	public String getStrasse() {
		return Strasse;
	}

	public void setStrasse(String strasse) {
		Strasse = strasse;
	}

	public int getPLZ() {
		return PLZ;
	}

	public void setPLZ(int pLZ) {
		PLZ = pLZ;
	}

	public int getHnr() {
		return Hnr;
	}

	public void setHnr(int hnr) {
		Hnr = hnr;
	}
	
	
}
