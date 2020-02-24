
public class PizzaFactory {
	
	public static IPizza getPizza(String p) {
		IPizza pizza = null;
		if (p.equals("Margherita")) {
			pizza = new Margherita();
		} else if (p.equals("Salami")) {
			pizza = new Salami();
		} else if (p.equals("Diavolo")) {
			pizza = new Diavolo();
		}
		return pizza;
	}
	
}
