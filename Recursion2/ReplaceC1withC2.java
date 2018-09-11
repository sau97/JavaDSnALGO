package Recursion2;

public class ReplaceC1withC2 {
	public static String replaceCharacter(String input,char c1,char c2) {
		
		return func(input,c1,c2,0);
	}
	public static String func(String input,char c1,char c2,int si) {
		if(si>=input.length())
			return input;
		String a ="";
		if(input.charAt(si)==c1) {
			a = input.substring(0,si)+c2+input.substring(si+1);
			return func(a,c1,c2,si+1);
		}
		return func(input,c1,c2,si+1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(replaceCharacter("abababab", 'a', 'x'));
	}
}
