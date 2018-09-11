package Recursion2;
import java.util.Scanner;
public class BinarySearch {
	public static int binarySearch(int a[],int n) {
		return bs(a,n,0,a.length-1);
	}
	public static int bs(int a[],int num, int ind,int lind )
	{
		if(ind>lind)
			return -1;
		int mid = ind + (lind-ind)/2;
		 if(a[mid] == num)
				return mid;
		
		if(a[mid]>num)
			return bs(a,num,ind,mid-1);
		else if(a[mid]<num)
			return bs(a,num,mid+1,lind);
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int a [] = new int [n];
		for(int i = 0;i<n;i++)
			a[i] = s.nextInt();
		int k = s.nextInt();
		System.out.println(binarySearch(a,k));
	}

}
