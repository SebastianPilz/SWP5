
public class Schnitzel extends Gericht{
	String name = "Schnitzel";
	double preis = 5.00;
	
	public void desc() {
		System.out.println(name);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPreis() {
		return preis;
	}
	
	public void setPreis(double preis) {
		this.preis = preis;
	}
}
