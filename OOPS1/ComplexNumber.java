package OOPS1;
import java.util.Scanner;

public class ComplexNumber {
	private int real;
	private int imaginary;
	public ComplexNumber(int real,int imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}
	public int getImaginary() {
		return imaginary;
	}
	public int getReal() {
		return real;
	}
	public void setReal(int real) {
		this.real = real;
	}
	public void setImaginary(int imaginary) {
		this.imaginary = imaginary;
	}
	public void print() {
		System.out.println(real + "+i"+imaginary);
	}
	public void add(ComplexNumber c2) {
		this.real = this.real + c2.real;
		this.imaginary = this.imaginary + c2.imaginary;
	}
	public void multiply(ComplexNumber c2) {
		int k = (this.imaginary*c2.real) + (this.real*c2.imaginary);
		this.real = this.real*c2.real - this.imaginary*c2.imaginary;
		this.imaginary = k;
	}
	public ComplexNumber conjugate() {
		int a = this.real;
		int b = this.imaginary;
		ComplexNumber c2 = new ComplexNumber(a,-b);
		return c2;
	}
	public static ComplexNumber add(ComplexNumber c1 , ComplexNumber c3) {
		int a = c1.real + c3.real;
		int b = c1.imaginary + c3.imaginary;
		ComplexNumber c2 = new ComplexNumber(a,b);
		return c2;
	}
	public static void main(String []args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		ComplexNumber c1 = new ComplexNumber(a,b);
		a  = s.nextInt();
		b = s.nextInt();
		//c1.print();
		ComplexNumber c2 = new ComplexNumber(a,b);
		//c2.print();
		int c = s.nextInt();
		if(c == 1) {
			c1.add(c2);
			c1.print();
		}
		else if(c==2) {
			c1.multiply(c2);
			c1.print();
		}
		
	}
}
