package Recursion2;

public class printSubsequences {
	public static void printSubs(String input) {
		printSubs(input,"");
	}
	public static void printSubs(String input,String outputSoFar) {
		if(input.length()==0) {
			System.out.println(outputSoFar);
			return;}
		printSubs(input.substring(1),outputSoFar);
		printSubs(input.substring(1),outputSoFar+input.charAt(0));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printSubs("xyz");
	}

}
