package Recursion;

public class removeX {

	public static String removex(String input) {
		String x = func(input,0);
		if(x.charAt(x.length()-1)=='x')
			x = x.substring(0,x.length()-1);
		return x;
	}
	public static String func(String input,int si) {
		if(si == input.length()-1)
			return input;
		if(input.charAt(si)=='x') {
			String s = input.substring(0, si)+input.substring(si+1);
			return func(s,si);
		}
		return func(input,si+1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removex("xox"));
	}

}
