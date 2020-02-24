import java.util.ArrayList;

public class Margherita implements IPizza{
	String Name = "Margherita";
	ArrayList<String> zutaten = new ArrayList<>();
	
	public Margherita() {
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return Name;
	}

	@Override
	public String toString() {
		return "Margherita [Name=" + Name + ", zutaten=" + zutaten + "]";
	}

	
	
}
