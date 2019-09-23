
public class Seb implements Observer{

	@Override
	public void update(int a) {
		System.out.printf("Servus Seb, es hat jetzt %d°\n", a);
	}
}
