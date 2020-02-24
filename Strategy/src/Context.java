
public class Context {
	IStrategy i = null;
	
	public Context(IStrategy i) {
		this.i = i;
	}
	
	public double execute(double a, double b) {
		return i.operate(a, b);
	}
	
}
