package DP2;

public class EditDistance {

	public static int editR(String s, String t) {
		if(s.length()==0)
			return t.length();
		if(t.length()==0)
			return s.length();
		if(s.charAt(0)==t.charAt(0))
			return editR(s.substring(1),t.substring(1));
		
		int op1 = editR(s.substring(1),t);//delete
		int op2 = editR(s,t.substring(1));//insert
		int op3 = editR(s.substring(1),t.substring(1));//substitude
		
		return 1+Math.min(op1,Math.min(op2, op3));
	}
	public static int editM(String s,String t) {
		int storage[][] = new int [s.length()+1][t.length()+1];
		for(int i=0;i<s.length()+1;i++)
			for(int j=0;j<t.length()+1;j++) {
				storage[i][j]=-1;
			}
		return editM(s,t,storage);
	}
	public static int editM(String s,String t,int storage[][]) {
		int m = s.length();
		int n = t.length();
		if(m==0 && n==0)
			return 0;
		if(m==0)
		{
			storage[m][n] = n;
			return n;
		}
		if(n ==0) {
			storage[m][n] = m;
			return m;
		}
		if(storage[m][n]!=-1)
			return storage[m][n];
		
		if(s.charAt(0)==t.charAt(0)) {
			storage[m][n] = editM(s.substring(1),t.substring(1));
			return storage[m][n];
		}
		else {
			int op1 = editM(s.substring(1),t,storage);
			int op2 = editM(s,t.substring(1),storage);
			int op3 = editM(s.substring(1),t.substring(1),storage);
			storage[m][n] = 1 + Math.min(op1, Math.min(op2, op3));
		}
		return storage[m][n];
	}
	public static int editDP(String s,String t) {
		int m = s.length();
		int n = t.length();
		int storage[][] = new int [m+1][n+1];
		
		for(int i=0;i<=m;i++)
			storage[i][0] = i;
		for(int j = 0;j<=n;j++)
			storage[0][j] = j;
		for(int i = 1;i<=m;i++)
			for(int j = 1;j<=n;j++) {
				if(s.charAt(i-1) == t.charAt(j-1)) {
					storage[i][j] = storage[i-1][j-1];
				}
				else {
					int op1 = storage[i-1][j];
					int op2 = storage[i][j-1];
					int op3 = storage[i-1][j-1];
					storage[i][j] = 1 +Math.min(op1, Math.min(op2, op3));
				}
			}
		return storage[m][n];
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "adefdfde";
		String t = "fdgbdefd";
		System.out.println(editDP(s,t));
		System.out.println(editR(s,t));
		System.out.println(editM(s,t));
	}

}
