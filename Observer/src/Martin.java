
public class Martin implements Observer{

	@Override
	public void update(int a) {
		System.out.printf("Servus Martin, es hat jetzt %d°\n", a);
	}
}
