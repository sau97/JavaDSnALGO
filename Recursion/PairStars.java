package Recursion;

public class PairStars {

	public static String addStars(String input) {
		return func(input,0);
	}
	public static String func(String input,int si) {
		if(si>=input.length()-1)
			return input;
		if(input.charAt(si)==input.charAt(si+1)) {
			input = input.substring(0,si+1)+"*"+input.substring(si+1);
			return func(input,si+1);
		}
		return func(input,si+1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addStars("lllll"));
	}

}
