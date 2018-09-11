package Recursion2;
import java.util.Scanner;
public class KeyPadCode {
	public static String [] helper(int n) {
		String a[] = new String[3];
		switch(n) {
		case 0:
			String b [] = {""};
			return b;
		case 1:
			String c[] = {""};
			return c;
		case 2:
			a[0] = "a";
			a[1]="b";
			a[2] ="c";
			return a;
		case 3:
			a[0] ="d";
			a[1] ="e";
			a[2] ="f";
			return a;
		case 4:
			a[0] ="g";
			a[1] ="h";
			a[2] ="i";
			return a;
		case 5:
			a[0] ="j";
			a[1] ="k";
			a[2] ="l";
			return a;
		case 6:
			a[0] ="m";
			a[1] ="n";
			a[2] ="o";
			return a;
		case 7:
			String ab[] = new String[4];
			ab[0] ="p";
			ab[1] ="q";
			ab[2] ="r";
			ab[3] = "s";
			return ab;
		case 8:
			a[0] ="t";
			a[1] ="u";
			a[2] ="v";
			return a;
		case 9:
			String cd[] = new String[4];
			cd[0] ="w";
			cd[1] ="x";
			cd[2] ="y";
			cd[3] = "z";
			return cd;
		}
		return a;
	}
	public static String[] keyPad(int num) {
		if(num==0) {
			String ans[]= {""};
			return ans;
		}
	String ans[] = keyPad(num/10);
	int n = num%10;
	String smallAns[] = helper(n);
	if(n==1 || n==0)
	{
		String arr [] = ans ;
	}
	else if(n!=7 && n!=9) {
	String arr[] = new String [3*ans.length];
	for(int i = 0,j=0;i<ans.length&&j<arr.length;i++,j+=3) {
		arr[j] = ans[i]+smallAns[0];
		arr[j+1] = ans[i]+ smallAns[1];
		arr[j+2] = ans[i]+smallAns[2];
	}
	return arr;
}
	else if(n == 7 || n==9) {
		String arr[] = new String [4*ans.length];
		for(int i = 0,j=0;i<ans.length&&j<arr.length;i++,j+=4) {
			arr[j] = ans[i]+smallAns[0];
			arr[j+1] = ans[i]+ smallAns[1];
			arr[j+2] = ans[i]+smallAns[2];
			arr[j+3] = ans[i]+smallAns[3];
		}
		return arr;
	}
	return ans;
	
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		String ans[] = keyPad(n);
		for(int i = 0;i<ans.length;i++)
			System.out.println(ans[i]);
		System.out.println(ans.length);
	}

}
