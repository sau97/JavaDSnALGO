package Recursion2;

public class PrintKeypad {
	
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
	public static void printkey(int input) {
		print(input,"");
	}
	public static void print(int num, String Output) {
		if(num==0) {
			System.out.println(Output);
			return;
		}
		int n = num%10;
		String arr[] = helper(n);
		int m = n/10;
		if(n!=7 && n!=9 && n!=0 && n!=1) {
			print(num/10,arr[0]+Output);
			print(num/10,arr[1]+Output);
			print(num/10,arr[2]+Output);
		}
		else if(n==7 || n==9) {
			print(num/10,arr[0]+Output);
			print(num/10,arr[1]+Output);
			print(num/10,arr[2]+Output);
			print(num/10,arr[3]+Output);
		}
		else if(n==1 || n==0) {
			print(num/10,Output);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printkey(23);
	}

}
