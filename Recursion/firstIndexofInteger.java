package Recursion;
import java.util.Scanner;
public class firstIndexofInteger {
	public static int firstIndex(int input[],int x) {
		if(input.length<=1000 && input.length>=1)
			return func(input,x,0);
		return -1;
	}
public static int func(int a[],int num,int si) {
	if(si>=	a.length)
		return -1;
	if(a[si]==num)
		return si;
	return func(a,num,si+1);
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
		System.out.println(firstIndex(a,ind));
		
	}

}
