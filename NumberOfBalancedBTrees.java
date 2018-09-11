package DP;

public class NumberOfBalancedBTrees {
	
	public static int count(int h) {
		int mod = (int)(Math.pow(10, 9)+7);
		return count(h,mod);
	}
	public static int count(int h,int mod) {
		if(h==0||h==1)
			return 1;
		int x = count(h-1,mod);
		int y = count(h-2,mod);
		long res1 = (long)x*x;
		long res2 = (long) x*y*2;
		int val1 = (int)(res1%mod);
		int val2 = (int)(res2%mod);
		return (val1+val2)%mod;
	}
	public static int countDP(int n) {
		int storage[] = new int[n+1];
		int mod = (int)Math.pow(10, 9)+7;
		return countDP(storage,n,mod);
	}
	public static int countDP(int storage[],int n,int mod) {
		storage[0]=1;
		storage[1]=1;
		for(int i=2;i<storage.length;i++) {
			int x = storage[i-1];
			int y = storage[i-2];
			long res1 = (long)x *x;
			long res2 = (long)x*y*2;
			int val1 = (int)(res1%mod);
			int val2 = (int)(res2%mod);
			storage[i] = (val1+val2)%mod;
		}
		//return storage[n];
		return storage[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(count(6));
		System.out.println(countDP(6));
	}

}
