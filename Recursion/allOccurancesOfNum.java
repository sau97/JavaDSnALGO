package Recursion;
import java.util.Scanner;
public class allOccurancesOfNum {
public static int[] allIndexes(int input[],int x) {
	int fin [] = new int [input.length];
	for(int i = 0;i<fin.length;i++)
		fin[i]=-10;
	int ans[] = func(input,x,0,fin,0);
	int cnt = 0;
	for(int i = 0;i<fin.length;i++)
		if(fin[i]!=-10)
		cnt++;
	int finalans [] = new int [cnt];
	for(int i= 0;i<finalans.length;i++)
		if(ans[i]!=-10)
			finalans[i] = ans[i];
	//System.out.println("len"+finalans.length);
	return finalans;
}
public static int[] func(int a[],int num, int si,int fin[],int finind) {
	if(si==a.length)
		return fin;
	if(a[si] == num)
	{
		fin[finind]= si;
		return func(a,num,si+1,fin,finind+1);
	}
	return func(a,num,si+1,fin,finind);
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int len = s.nextInt();
		int a [] = new int [len];
		for(int i = 0;i<len;i++) {
			a[i]=s.nextInt();
		}
		int num = s.nextInt();
		int b [] = allIndexes(a,num);
		for(int i = 0;i<b.length;i++) {
			System.out.print(b[i]+" ");
		}
	}

}
