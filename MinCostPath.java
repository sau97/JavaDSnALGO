package DP2;

public class MinCostPath {
	public static int minCostPath(int input[][]) {
	
		return minCostPath(input,input.length-1,input[0].length-1);
		
	}
	public static int minCostPath(int input[][],int m,int n) {
		if(n<0 || m<0)
			return Integer.MAX_VALUE;
		if(n==0 && m==0)
			return input[m][n];
		else
			return input[m][n] + min(minCostPath(input,m-1,n-1),minCostPath(input,m-1,n),minCostPath(input,m,n-1));
		
	}
	public static int minCost(int input[][],int m,int n) {
		if(n==input[0].length-1&&m==input.length-1)
			return input[m][n];
			if(m>=input.length || n>=input[0].length)
				return Integer.MAX_VALUE;
			
			int op1 = minCost(input,m+1,n);
			int op2 = minCost(input,m,n+1);
			int op3 = minCost(input,m+1,n+1);
			return input[m][n]+Math.min(op1, Math.min(op2, op3));
	}
	public static int minCostPathM(int arr[][]){
		int m = arr.length;
		int n = arr[0].length;
		int storage[][] = new int[m][n];
		for(int i = 0; i < m ; i++){
			for(int j = 0; j < n; j++){
				storage[i][j] = -1;
			}
		}
		return minCostPathM(arr, 0, 0, storage);
	}

	private static int minCostPathM(int[][] arr, int i, int j, int[][] storage) {
		int m = arr.length;
		int n = arr[0].length;

		if(i >= m || j >= n){
			return Integer.MAX_VALUE;
		}

		if(i == m - 1 && j == n - 1){
			storage[m - 1][n - 1] = arr[i][j];
			return storage[i][j];
		}

		if(storage[i][j] != -1){
			return storage[i][j];
		}

		int op1 = minCostPathM(arr, i , j + 1, storage);
		int op2 = minCostPathM(arr, i + 1 , j + 1, storage);
		int op3 = minCostPathM(arr, i + 1, j, storage );
		storage[i][j] = arr[i][j] + Math.min(op1,  Math.min(op2, op3));
		return storage[i][j];
	}
	public static int minCostDP(int arr[][]) {
		int m = arr.length;
		int n = arr[0].length;
		int storage[][] = new int [m][n];
		storage[m-1][n-1] = arr[m-1][n-1];
		
		//Filling last row and last column
		for(int j=n-2;j>=0;j--)
		{
			storage[m-1][j] = storage[m-1][j+1]+arr[m-1][j];
		}
		
		for(int i = m-2;i>=0;i--) {
			storage[i][n-1] = storage[i+1][n-1] + arr[i][n-1];
		}
		//Now calculating entire storage
		for(int i=m-2;i>=0;i--)
			for(int j = n-2;j>=0;j--) {
				storage[i][j] = arr[i][j]+ Math.min(storage[i+1][j], Math.min(storage[i][j+1], storage[i+1][j+1]));
			}
		return storage[0][0];
		
	}

	
	
	public static int min(int x,int y, int z) {
		int min=0;
		if(x==Integer.MAX_VALUE && y==Integer.MAX_VALUE && z==Integer.MAX_VALUE)
			return 0;
		if(x<=y&&x<=z)
			min= x;
		else if(y<=x && y<=z)
			min= y;
		else
			min= z;
		return min;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[][] = {{3,4,1,2},{2,1,8,9},{4,7,8,1}};
		
		System.out.println(minCostPath(input));
		System.out.println(minCost(input,0,0));
		System.out.println(minCostPathM(input));
		System.out.println(minCostDP(input));
	}

}
