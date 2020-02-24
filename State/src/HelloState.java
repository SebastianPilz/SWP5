import java.util.Scanner;

public class HelloState implements IState{

	@Override
	public void goNext(Context c) {
		c.setState(new ZahlState());
	}

	@Override
	public boolean Conversation(Scanner s) {
		System.out.println("Hallo und herzlich willkommen bei SIMAY");
		System.out.println("Was griagsch?");
		String bestellung = s.nextLine();
		if (bestellung.equals("Margherita")) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void cancel(Context c) {
		c.setState(new HelloState());
	}

}
