import java.util.ArrayList;

public class Salami implements IPizza {
	String Name = "Salami";
	ArrayList<String> zutaten = new ArrayList<>();

	public Salami() {
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return Name;
	}

	@Override
	public String toString() {
		return "Salami [Name=" + Name + ", zutaten=" + zutaten + "]";
	}

}
