import java.util.Scanner;

public class FertigState implements IState{

	@Override
	public void goNext(Context c) {
		c.setState(new HelloState());
	}

	@Override
	public boolean Conversation(Scanner s) {
		System.out.println("Passt habn ma alls gregelt");
		return false;
	}

	@Override
	public void cancel(Context c) {
		c.setState(new HelloState());
	}

}
