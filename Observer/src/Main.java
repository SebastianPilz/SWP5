
public class Main {

	public static void main(String[] args) {
		Heizung h = new Heizung();
		Martin m = new Martin();
		Seb s = new Seb();
		
		h.register(m, 29);
		h.register(s, 27);
		h.setValue(25);
		h.setValue(28);
		h.setValue(30);
		h.unRegister(m);
		h.setValue(29);
	}

}
