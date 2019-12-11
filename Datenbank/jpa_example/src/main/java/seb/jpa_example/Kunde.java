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
	
	
}
