package algorithm.DE;

public class Bound {
	
	private double upper;
	private double lower;
	
	public Bound(double lower, double upper) {
		setLower(lower);
		setUpper(upper);
	}

	public void setUpper(double upper) {this.upper = upper;}
	public void setLower(double lower) {this.lower = lower;}
	
	public double getUpper() {return upper;}
	public double getLower() {return lower;}
}
