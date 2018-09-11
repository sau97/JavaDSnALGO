package Recursion;

import java.util.Scanner;

public class LastIndexofaNumber {

	public static int lastIndex(int input[],int x) {
		if(input.length<=1000 && input.length>=1)
			return func(input,x,input.length-1);
		return -1;
	}
public static int func(int a[],int num,int len) {
	if(len<0)
		return -1;
	if(a[len]==num)
		return len;
	return func(a,num,len-1);
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int a[] = new int [s.nextInt()];
		int len = s.nextInt();
		for(int i = 0;i<len;i++) {
			a[i]=s.nextInt();
		}
		int ind = s.nextInt();
		System.out.println(lastIndex(a,ind));
		
	}

}
