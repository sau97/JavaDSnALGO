package DPprac;

public class CoinTower {

	public static String solve(int n,int x,int y){
		
		int dp[] = new int [n+1];
		dp[1] = 1;
		dp[x]=1;
		dp[y]=1;
		for(int i=2;i<n+1;i++) {
			if(i==x || i == y)
				continue;
			int a = xor(dp[i-1]);
			int b;
			if(i-x>0)
				b = xor(dp[i-x]);
			else
				b = Integer.MIN_VALUE;
			int c = Integer.MIN_VALUE;
			if(i-y>0)
				c = xor(dp[i-y]);
			dp[i] = Math.max(a, Math.max(b, c));
		}
		for(int i = 1;i<dp.length;i++)
			System.out.print(dp[i]+" ");
		if(dp[n]==1)
			return "Beerus";
		else
			return "Whis";
			
		}
	public static int xor(int n) {
		if(n==0)
			return 1;
		return 0;
	}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			System.out.println(solve(4,2,3));
		}

}
