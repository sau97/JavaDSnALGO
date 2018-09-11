package Recursion;

public class sumofarray {
	
	public static int sum(int a[]) {
		return sum1(a,a.length-1);
	}
	public static int sum1(int a[],int n) {
		if(n<0)
			return 0;
		return a[n]+sum1(a,n-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = new int [5];
		for(int i = 0;i<a.length;i++) {
			a[i]=i+1;
		}
		System.out.println(sum(a));
	}

}
