package seb.jpa_example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Kunde {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter
	@Getter
	private long id;
	@Setter
	@Getter
	private String TitelV;
	@Setter
	@Getter
	private String Vorname;
	@Setter
	@Getter
	private String Nachname;
	@Setter
	@Getter
	private String TitelN;

	public Kunde() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Kunde(String titelV, String vorname, String nachname, String titelN) {
		super();
		TitelV = titelV;
		Vorname = vorname;
		Nachname = nachname;
		TitelN = titelN;
	}

	@Override
	public String toString() {
		return "Kunde [id=" + id + ",\n TitelV=" + TitelV + ",\n Vorname=" + Vorname + ",\n Nachname=" + Nachname
				+ ",\n TitelN=" + TitelN + "]\n";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitelV() {
		return TitelV;
	}

	public void setTitelV(String titelV) {
		TitelV = titelV;
	}

	public String getVorname() {
		return Vorname;
	}

	public void setVorname(String vorname) {
		Vorname = vorname;
	}

	public String getNachname() {
		return Nachname;
	}

	public void setNachname(String nachname) {
		Nachname = nachname;
	}

	public String getTitelN() {
		return TitelN;
	}

	public void setTitelN(String titelN) {
		TitelN = titelN;
	}
	
	
}
