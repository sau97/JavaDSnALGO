package DP;

public class MinStepstoOne {

	public static int countStepsTo1(int n){
		
		if(n==1)
			return 0;
		int op1 = countStepsTo1(n-1);
		int minSteps = op1;
		if(n%2==0) {
			int op2 = countStepsTo1(n/2);
			if(op2<minSteps)
				minSteps = op2;
		}
		if(n%3 == 0) {
			int op3 = countStepsTo1(n/3);
			if(op3<minSteps)
				minSteps = op3;
		}
		return 1+minSteps;
		
		}
	public static int countStepsTo1M(int n) {
		int storage[] = new int [n+1];
		return countStepsTo1M(storage,n);
	}
	public static int countStepsTo1M(int []storage,int n) {
		if(n==1) {
			storage[n] =0;
			return storage[n];
		}
		if(storage[n]!=0)
			return storage[n];
		int op1 = countStepsTo1M(storage, n-1);
		int minSteps = op1;
		if(n%2==0) {
			int op2 = countStepsTo1M(storage,n/2);
			if(op2<minSteps)
				minSteps = op2;
		}
		if(n%3 == 0) {
			int op3 = countStepsTo1M(storage,n/3);
			if(op3<minSteps)
				minSteps = op3;
		}
		storage[n]= 1+minSteps;
		return storage[n];
		
	}
	public static int countStepsTo1DP(int n){
		
		int storage[] = new int [n+1];
		storage[1] = 0;
		for(int i = 2;i<storage.length;i++) {
			int op1 = storage[i-1];
			int min = op1;
			if(i%2==0) {
				int op2 = storage[i/2];
				if(op2<min)
					min = op2;
			}
			if(i%3==0) {
				int op3 = storage[i/3];
				if(op3<min)
					min = op3;
			}
			storage[i] = 1+min;
		}
		return storage[n];
		
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countStepsTo1(100));
		System.out.println(countStepsTo1M(100));
		System.out.println(countStepsTo1DP(100));
	}

}
