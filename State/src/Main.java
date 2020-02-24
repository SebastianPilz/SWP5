import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Context c = new Context();
		while (c.show(s) == true) {
			c.advance();
		}
		
	}

}
