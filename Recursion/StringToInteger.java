package Recursion;

public class StringToInteger {
	
	public static int convertStringToInt(String input) {
		return func(input,0,0);
	}
	public static int func(String input,int si,int sum) {
		if(si>=input.length())
			return sum;
		int a = (int)input.charAt(si)-48;
		System.out.println(a);
		sum = sum*10 + a;
		return func(input,si+1,sum);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convertStringToInt("12345"));
	}

}
