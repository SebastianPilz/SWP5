
public class SoucenDec extends GerichtDecorator{
	Souce souce;
	String n = ", mit ";
	
	public SoucenDec(Gericht g, Souce s) {
		super(g);
		souce = s;
		
		if (souce == Souce.Ketchup) {
			n += "Ketchup";
		} else if (souce == Souce.Senf) {
			n += "Senf";
		} else if (souce == Souce.Mayo) {
			n += "Mayo";
		}
		g.setName(g.getName() + n);
		g.setPreis(g.getPreis() + 0.50);
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
