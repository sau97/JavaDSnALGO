package DPprac;

public class MatrixChainMultiplication {
	public static int mcmR(int p[]) {
		return mcmR(p,1,p.length-1);
	}
	public static int mcmR(int a[],int s,int e) {
		if(s==e)
			return 0;
		int min = Integer.MAX_VALUE;
		for(int i = s;i<e;i++) {
			int count  = mcmR(a,s,i)+mcmR(a,i+1,e)+a[s-1]*a[i]*a[e];
			
			min = Math.min(min, count);
		}
		return min;
	}
	public static int mcmDP(int p[]) {
		int storage[][] = new int [p.length][p.length];
		
		int count = 0;
		for(int d = 1;d<p.length-1;d++) {
			for(int i=1;i<p.length-d;i++) {
				int j = i+d;
				int min = Integer.MAX_VALUE;
				for(int k=i;k<j;k++) {
					count = storage[i][k]+storage[k+1][j]+p[i-1]*p[k]*p[j];
					min = Math.min(min, count);
				}
				storage[i][j] = min;
			}
		}
		return storage[1][p.length-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] {10,15,20,25};
		//System.out.println(mcmR(arr));
		System.out.println(mcmDP(arr));
	}
}
