package Recursion;

public class isSortedArray {
	public static boolean isSorted(int a[],int n) {
		if(n==0 || n==1)
			return true;
		if(a[n]>a[n-1])
			return isSorted(a,n-1);
		else 
			return false;
	}
	public static void main(String[]args) {
		int a[] = new int [5];
		for(int i=0;i<a.length;i++) {
			a[i]=i+1;
		}
		System.out.println(isSorted(a,a.length-1));
	}

}
