package Recursion2;

public class Subsequences {
	public static String[] findsubs(String str) {
		if(str.length()==0) {
			String[] ans = {""};
			return ans;
		}
		String smallAns[] = findsubs(str.substring(1));
		String finalans[] = new String [smallAns.length*2];
		for(int i=0;i<smallAns.length;i++)
			finalans[i] = smallAns[i];
		for(int i=0;i<smallAns.length;i++)
			finalans[i+smallAns.length] = str.charAt(0)+smallAns[i];
		return finalans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ans[]=findsubs("abc");
		for(int i=0;i<ans.length;i++)
			System.out.println(ans[i]);
	}

}
