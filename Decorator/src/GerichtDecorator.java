
public abstract class GerichtDecorator extends Gericht{
	protected Gericht gericht;
	
	public GerichtDecorator(Gericht g) {
		gericht = g;
	}
 }
