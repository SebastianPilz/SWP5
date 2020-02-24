import java.util.Scanner;

public interface IState {
	public void goNext(Context c);
	public boolean Conversation(Scanner s);
	public void cancel(Context c);
}
