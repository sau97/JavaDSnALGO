package Recursion;

public class replacepi {
	public static String replace(String input) {
		return func(input,0);
	}
	public static String func(String input,int si) {
		if(si == input.length()-1)
			return input;
		if(input.charAt(si)=='p'&&input.charAt(si+1)=='i') {
			input = input.substring(0, si)+"3.14"+input.substring(si+2);
			return func(input,si+2);
		}
		return func(input,si+1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(replace("pip"));
	}

}
