package TimeSpace;

import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

public class CheckRotation {
		public static int arrayRotateCheck(int[] arr) {
			int count=0;
			for(int i=0;i<arr.length-1;i++) {
				if(arr[i]<=arr[i+1])
					continue;
	
			else
			{	count = arr.length-i-1;
			break;}
		}

				count = arr.length-count;
	return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s =new Scanner(System.in);
		int n = s.nextInt();
		int a[] = new int [n];
		for(int i=0;i<a.length;i++)
			a[i]  =s.nextInt();
		System.out.println(arrayRotateCheck(a));

	}
	
}