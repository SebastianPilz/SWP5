
public class Main {

	public static void main(String[] args) {
		Schnitzel s = new Schnitzel();
		Gericht g = new BeilagenDec(s, Beilage.Pommes);
		Gericht g1 = new SoucenDec(s, Souce.Ketchup);
		s.desc();
		System.out.println(s.getPreis());
	}

}
