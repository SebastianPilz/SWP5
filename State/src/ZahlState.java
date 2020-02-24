import java.util.Scanner;

public class ZahlState implements IState{

	@Override
	public void goNext(Context c) {
		c.setState(new HaschState());
	}

	@Override
	public boolean Conversation(Scanner s) {
		System.out.println("4,20");
		String jawohl = s.nextLine();
		if (jawohl.equals("ja")) {
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
