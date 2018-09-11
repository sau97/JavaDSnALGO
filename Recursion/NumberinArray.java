package Recursion;

public class NumberinArray {
	public static boolean checkNumber(int input[], int x) {
		if(input.length>=1 && input.length<=1000)
      		return there(input,input.length-1,x);
      return false;
	}
	public static boolean there(int a[],int n,int num) {
		if(n<0)
			return false;
		if(a[n]==num)
			return true;
		return there(a,n-1,num);
	}
	public static void main(String []args) {
		int a[] = {1,2,3,4,5};
		System.out.println(checkNumber(a,5));
		System.out.println(checkSortedBetter(a));
	}

	public static boolean checkSortedBetter(int input[]) {
		if(input.length == 0 || input.length == 1)
			return true;
		if(input[input.length-1]<input[input.length-2])
			return false;
		int b[] = new int[input.length-1];
		for(int i = 0 ;i<input.length-1;i++) {
			b[i] = input[i];
		}
		input = b;
		return checkSortedBetter(input);
	}
}
