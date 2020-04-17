
public class Command1 implements Command{
	@Override
	public void execute() {
		System.data.stack_push("a");
	}

	@Override
	public void redo() {
		
	}

	@Override
	public void undo() {

	}
}
