package Recursion2;

public class RemoveDuplicate {
	public static String removeConsecutiveDuplicates(String s) {
		if(s.length()>=0 && s.length()<=1000)
			return func(s,0);
		return "";
	}
	public static String func(String s,int si) {
		if(si == s.length()-1)
			return s;
		if(s.charAt(si)==s.charAt(si+1))
		{	s = s.substring(0,si)+s.substring(si+1);
			return func(s,si);
		}
		return func(s,si+1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeConsecutiveDuplicates("aabxxxxccd"));
	}

}
