import java.util.Scanner;

public class HaschState implements IState{

	@Override
	public void goNext(Context c) {
		c.setState(new FertigState());
	}

	@Override
	public boolean Conversation(Scanner s) {
		System.out.println("Hasch 20 Cent?");
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
