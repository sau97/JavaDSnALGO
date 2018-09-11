package DP;

public class MinimumCountSquares {
	public static int count(int n) {
		if(n<=3)
			return n;
		int min = n;

		for(int i = 1;i<=Math.sqrt(n);i++)
		{
			int temp = i*i;
			if(temp>n)
				break;
			min = Math.min(min, 1+count(n-temp));
		}
		return min;
	}

	public static int countDP(int n)
	{
		int []storage = new int[n+1];
		return countDP(storage,n);
	}
	public static int countDP(int[]storage,int n) {
		storage[0]=0;
		storage[1]=1;
		storage[2]=2;
		storage[3]=3;
		for(int i = 4;i<storage.length;i++) {
			storage[i] = i;
			for(int x = 1;x<=Math.sqrt(i);x++) {
				int temp = x*x;
				if(temp>i)
					break;
				else
					storage[i] = Math.min(storage[i], 1+storage[i-temp]);
			}
		}
		return storage[n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countDP(67));
		System.out.println(count(67));
		
	}

}
