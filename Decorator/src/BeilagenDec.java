
public class BeilagenDec extends GerichtDecorator {
	Beilage beilage;
	String n = ", mit ";

	public BeilagenDec(Gericht g, Beilage b) {
		super(g);
		beilage = b;
		
		if (beilage == Beilage.Pommes) {
			n += "Pommes";
		} else if (beilage == Beilage.Kartoffelsalat) {
			n += "Kartoffelsalat";
		} else if (beilage == Beilage.Suppe) {
			n += "Suppe";
		}
		g.setName(g.getName() + n);
		g.setPreis(g.getPreis() + 1.00);
	}

	@Override
	public void desc() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getPreis() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPreis(double preis) {
		// TODO Auto-generated method stub
		
	}

}
