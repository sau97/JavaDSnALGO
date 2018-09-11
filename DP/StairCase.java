package DP;

public class StairCase {
	
	public static int stairCaseRec(int n) {
		if(n==1||n==0) 
			return 1;
		if(n<0)
			return 0;
		
		return stairCaseRec(n-1) + stairCaseRec(n-2)+ stairCaseRec(n-3);
	}
	public static long stairCaseDP(int n) {
		int storage[] = new int [n+1];
		return stairCaseDP(storage,n);
	}
	public static long stairCaseDP(int []storage,int n) {
		if(n==1 || n==0)
			return 1;
		if(n==2)
			return 2;
		storage[0] =1;
		storage[1] = 1;
		storage[2] = 2;
		for(int i=3;i<storage.length;i++) {
			storage[i] = storage[(i-1)]+storage[(i-2)]+storage[(i-3)];
		}
		return storage[n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(stairCaseRec(4));
		System.out.println(stairCaseDP(4));
	}

}
