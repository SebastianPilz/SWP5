
public class Client {

	public static void main(String[] args) throws InterruptedException {
		Invoker i=new Invoker(new Command1());
		i.run();
		i.run();
		i.redo();
	}
}
