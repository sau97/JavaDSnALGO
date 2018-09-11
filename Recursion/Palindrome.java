package Recursion;

public class Palindrome {
	public static boolean isStringPalindrome(String input) {
		return check(input,0,input.length()-1);
	}
	public static boolean check(String s,int si,int ei) {
		if(si>ei)
			return true;
		if(si == ei)
			return true;
		if(s.charAt(si)!=s.charAt(ei))
			return false;
		return check(s,si+1,ei-1); 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isStringPalindrome("arora"));
	}

}
