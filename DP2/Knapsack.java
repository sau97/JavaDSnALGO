package DP2;

public class Knapsack {
	

	public static int knapsack(int[] weight,int value[],int maxWeight, int n){
		if(n<=0)
			return 0;
		if(maxWeight<=0)
			return 0;
		if(weight[n-1]>maxWeight)
			return knapsack(weight,value,maxWeight,n-1);
		int op1 = value[n-1]+knapsack(weight,value,maxWeight-weight[n-1],n-1);
		int op2 = knapsack(weight,value,maxWeight,n-1);
		return Math.max(op1, op2);
	}
	public static int ksDP(int[] weight,int value[],int maxWeight){
		
		
		int storage[][] = new int [weight.length+1][maxWeight+1];
		for(int i=1;i<weight.length+1;i++)
			for(int j=1;j<maxWeight+1;j++) {
				if(weight[i-1]>j)
					storage[i][j]=storage[i-1][j];
				else {
				int op1 = value[i-1]+storage[i-1][j-weight[i-1]];
				int op2 = storage[i-1][j];
				storage[i][j] = Math.max(op1, op2);
			}
		}
	

		return storage[storage.length-1][maxWeight];
			
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int wt[] = {6,1,2,4,5};
		int val []= {10,5,4,8,3};
		System.out.println(knapsack(wt,val,5,5));
		System.out.println(ksDP(wt,val,5));
		
	}

}
