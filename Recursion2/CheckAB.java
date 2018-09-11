package Recursion2;
import java.util.Scanner;
public class CheckAB {
	public static boolean checkAB(String s) {
		if(s.length()!=0)
		return check(s);
		return false;
	}
	public static boolean check(String s) {
		if(s.length()==0) {
			return true;
		}
		if(s.charAt(0)=='a')
			return check(s.substring(1));
		else if(s.charAt(0)=='b' && s.charAt(1)=='b')
			return check(s.substring(2));
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		System.out.println(checkAB(str));
	}

}
