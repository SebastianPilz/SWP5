import java.util.ArrayList;

public class Diavolo implements IPizza {
	String Name = "Diavolo";
	ArrayList<String> zutaten = new ArrayList<>();

	public Diavolo() {

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return Name;
	}

	@Override
	public String toString() {
		return "Diavolo [Name=" + Name + ", zutaten=" + zutaten + "]";
	}

}
