
public class StackS<T> {
	private StackS<T> stack;

	public StackS() {
		stack=new StackS<T>();
	}

	void stack_push(T value) {
		stack.push(value);
		System.out.println(value);
	}

	void stack_pop() {
		stack.pop();
	}
}
