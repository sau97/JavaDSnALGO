package DP2;

public class LCS {

	public static int lcs(String s ,String t) {
		if(s.length()==0 || t.length()==0)
			return 0;
		if(s.charAt(0)==t.charAt(0))
			return 1 + lcs(s.substring(1),t.substring(1));
//		int op1 = lcs(s.substring(1),t.substring(1));  //This case has been handled implicitely
		int op2 = lcs(s,t.substring(1));
		int op3 = lcs(s.substring(1),t);
//		return Math.max(op1,Math.max(op2, op3));
		return Math.max(op2, op3);
	}
	public static int lcsM(String s,String t) {
		int storage[][] = new int [s.length()+1][t.length()+1];
		for(int i=0;i<=s.length();i++)
			for(int j=0;j<=t.length();j++)
				storage[i][j]=-1;
		
		return lcsM(s,t,storage);
	}
	public static int lcsM(String s,String t,int storage[][]) {
		int m = s.length();
		int n = t.length();
		
		if(storage[m][n]!=-1)
			return storage[m][n];
		if(m==0 || n==0) {
			storage[m][n]=0;
		return storage[m][n];
		}
		if(s.charAt(0) == t.charAt(0)){
			storage[m][n] = 1+lcsM(s.substring(1),t.substring(1),storage);
			return storage[m][n];
		}
		else {
		int op2 = lcsM(s,t.substring(1),storage);
		int op3 = lcsM(s.substring(1),t,storage);
		storage[m][n] = Math.max(op2, op3);
		return storage[m][n];
		}
		
	}
	
	public static int lcsDP(String s ,String t) {
		int m = s.length();
		int n = t.length();
		int storage[][] = new int [m+1][n+1];

		for(int i = 0; i<=m;i++)
			for(int j = 0;j<= n;j++) {
				if(i==0||j==0) {
					storage[i][j]=0;
					continue;
				}
				if(s.charAt(m-i) == t.charAt(n-j)){ //s.charAt(i-1) == t.charAt(j-1)
					storage[i][j] = 1+storage[i-1][j-1];
					continue;
				}
				storage[i][j] = Math.max(storage[i-1][j], storage[i][j-1]);
			}
		return storage[m][n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "degei";
		String t = "begie";
		System.out.println(lcsDP(s,t));
		System.out.println(lcsM(s,t));
		System.out.println(lcs(s,t));
		
	}

}
