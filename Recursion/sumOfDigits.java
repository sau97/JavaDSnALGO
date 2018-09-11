package Recursion;

public class sumOfDigits {

	public static int sod(int n) {
		if(n==0)
			return 0;
		int k = n%10;
		return k + sod(n/10);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sod(12345));
	}

}
