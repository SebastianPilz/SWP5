
public class Burger {
	String name = "Burger";
	double preis = 5.50;
	
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
