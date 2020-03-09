import java.util.ArrayList;

public class Composite implements IComponent{
	
	ArrayList<IComponent> a = new ArrayList<>();
	
	public void add(IComponent c) {
		a.add(c);
	}
	
	public void remove(IComponent c) {
		a.remove(c);
	}
	
	public void getChild(int i) {
		a.get(i);
	}
	
	@Override
	public void operation() {
		// TODO Auto-generated method stub
		
	}

}
