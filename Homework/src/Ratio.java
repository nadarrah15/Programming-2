
public class Ratio {
	
	protected int numerator;
	protected int denominator;
	
	public Ratio(int top, int bottom){
		numerator = top;
		denominator = bottom;
		reduce();
	}
	
	public Ratio(int one){
		numerator = one;
		denominator = 1;
		reduce();
	}
	
	public Ratio(){
		numerator = 1;
		denominator = 1;
	}
	
	public int getNumerator(){
		return numerator;
	}
	
	public int getDenominator(){
		return denominator;
	}
	
	public double getValue(){
		return (double) numerator / (double) denominator;
	}
	
	public Ratio add(Ratio other){
		return new Ratio(this.numerator * other.numerator
				+ this.denominator * other.denominator,
				this.denominator * other.denominator);
	}

	protected void reduce(){
		int divisor = gcd(numerator, denominator);
		if (denominator < 0) divisor = -divisor;
		numerator /= divisor;
		denominator /= divisor;
	}
	
	protected static int gcd(int a, int b){
		if(a < 0) return gcd(-a ,b);
		if(a == 0) {
			if (b == 0) return 1;
			else return b;
		}
		if (b < a) return gcd(b, a);
		return gcd(b%a, a);
	}
	
	public String toString(){
		return getNumerator()+"/"+getDenominator();
	}
	
	public Ratio subtract(Ratio other){
		return new Ratio(this.numerator * other.numerator
				- this.denominator * other.denominator,
				this.denominator * other.denominator);
	}
	
	public Ratio multiply(Ratio other){
		return new Ratio(this.numerator * other.numerator,
				this.denominator * other.denominator);
	}
	
	public Ratio divide(Ratio other){
		return new Ratio(this.numerator * other.denominator,
				this.denominator * this.numerator);
	}
}
