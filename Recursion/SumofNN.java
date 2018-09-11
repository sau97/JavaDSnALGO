package Recursion;

public class SumofNN {
	public static int sum(int n) {
		if(n==1)
			return 1;
		return n + sum(n-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sum(4));
	}

}
