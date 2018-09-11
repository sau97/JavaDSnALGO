package OOPS1;

public class Fraction {
	private int numerator;
	private int denominator;
	
	public Fraction(int numerator , int denominator) {
		
		this.numerator = numerator;
		if (denominator == 0) {
			//TODO 
		}
		this.denominator = denominator;
		simplify();
	}
	private void simplify() {
		int gcd =1;
		for(int k = 1;k<=numerator && k<=denominator;k++) {
			if(numerator%k == 0 && denominator%k == 0)
				gcd = k;
		}
		numerator = numerator/gcd;
		denominator = denominator/gcd;
	}
	public int getDenominator() {
		return denominator;
	}
	public int getNumerator() {
		return numerator;
	}
	public void setNumerator(int n) {
		this.numerator = n;
		simplify();
	}
	public void setDenominator(int d)
	{
		if(d == 0) {
			return;	
		}
		this.denominator = d;
		simplify();
	}
	public void print() {
		if(denominator == 1) {
			System.out.println(numerator);}
		else {
			System.out.println(numerator+"/"+denominator);
		}
		}
	public static Fraction add(Fraction f1, Fraction f2) {
		int newNum = f1.numerator*f2.denominator+f1.denominator*f2.numerator;
		int newDen = f1.denominator*f2.denominator;
		Fraction f  = new Fraction(newNum,newDen);
		return f;
	}
	public void add(Fraction f2) {
		this.numerator = this.numerator*f2.denominator + this.denominator*f2.numerator;
		this.denominator = this.denominator*f2.denominator;
		simplify();
	}
	public void multiply(Fraction f2) {
		this.numerator = this.numerator*f2.numerator;
		this.denominator = this.denominator*f2.denominator;
		simplify();
	}
	
	}
