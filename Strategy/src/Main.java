
public class Main {

	public static void main(String[] args) {
		Context c = new Context(new Add());
		double erg = c.execute(2,2);
		System.out.println(erg);
	}

}
