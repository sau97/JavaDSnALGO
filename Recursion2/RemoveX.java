package Recursion2;

public class RemoveX {
	public static String removeX(String s) {
		if(s.length()==0)
			return s;
		String ans = "";
		if(s.charAt(0)!='x')
			ans = ans + s.charAt(0);
		return ans + removeX(s.substring(1));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeX("xoxoxox"));
	}

}
