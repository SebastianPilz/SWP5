import java.util.Scanner;

public class Context {
	private IState state = new HelloState();
	
	public void setState(IState state) {
		this.state = state;
	}
	
	public boolean show(Scanner s) {
		return state.Conversation(s);
	}
	
	public void advance() {
		state.goNext(this);
	}
	
	public void cancel() {
		state.cancel(this);
	}
}
