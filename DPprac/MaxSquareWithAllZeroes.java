package DPprac;

public class MaxSquareWithAllZeroes {
	public static int findMaxSquareWithAllZeroes(int a[][]) {
		int dp[][] = new int [a.length][a[0].length];
		for(int i = 0;i<a.length;i++) 
			for(int j = 0;j<a[0].length;j++) 
				if(a[i][j]==0)
					dp[i][j]=1;
		for(int i = 0;i<a[0].length;i++) {
			if(a[0][i]==0)
				dp[0][i]=1;
		}
		for(int i = 0;i<a.length;i++) {
			if(a[i][0]==0)
				dp[i][0]=1;
		}
		for(int i =1;i<a.length;i++)
			for(int j = 1;j<a[0].length;j++) {
				if(dp[i-1][j-1]>=1 && dp[i-1][j]>=1 && dp[i][j-1]>=1 && a[i][j]==0)
				{
					if(dp[i-1][j-1]==dp[i-1][j] && dp[i-1][j-1]==dp[i][j-1])
						dp[i][j] = dp[i-1][j-1]+1;
					else {
						dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]))+1;
	
					}
				}
				else if(a[i][j]==0) {
					dp[i][j]=1;
				}
				else if(a[i][j]==1)
					dp[i][j]=0;
			}
		int max=Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++)
			for(int j = 0;j<a[0].length;j++)
				if(max<dp[i][j])
					max = dp[i][j];
		
		return max;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = {{1,0,0},{1,0,0},{1,1,1}};
		System.out.println(findMaxSquareWithAllZeroes(a));
	}


}
