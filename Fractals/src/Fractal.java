
public class Fractal {

	public double length;
	public double iterations;
	public double p;
	
	public Fractal(int length, int iterations) {
		super();
		this.length = length;
		this.iterations = iterations;
		
	}
	
	public double build() {
		
		p = this.length * 3;
		
		if (this.iterations == 0) {
			return p;
		} else if (this.iterations == 1){
			this.p += this.length/3 * 3;
			return this.p;
			
		}
		this.p += this.length/3 * 3;
		
		return build2(this, this.length/3, 1);
	}

	
	private double build2(Fractal f, double l, int i) {
		
		if (i == f.iterations) {
			return f.p;
		}
		
		f.p += l * 2;
		
		
		return build2(f, l / 3, i + 1);
		
		
		
		
		
	}




































	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
