package Recursion;

public class Multiply2Nos {
public static int mult(int m ,int n) {
	if(n==0)
		return 0;
	return m+mult(m,n-1);
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mult(3,5));
	}

}
