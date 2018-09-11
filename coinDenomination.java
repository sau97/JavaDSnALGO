package DPprac;

public interface coinDenomination {

	public static int countWaysToMakeChange(int denominations[], int value){

		return count(denominations,value,denominations.length);		

		}
	public static int count(int S[],int value,int m) {
		if(value==0)
			return 1;
		if(value<0)
			return 0;
		if(m<=0 && value>=1)
			return 0;
		return count(S,value,m-1)+count(S,value-S[m-1],m);
	}
	public static int countDP( int S[], int m, int n ) 
	{ 
	    // table[i] will be storing the number of solutions for 
	    // value i. We need n+1 rows as the table is constructed 
	    // in bottom up manner using the base case (n = 0) 
	    int table[]=new int[n+1]; 
	  
	    // Base case (If given value is 0) 
	    table[0] = 1; 
	  
	    // Pick all coins one by one and update the table[] values 
	    // after the index greater than or equal to the value of the 
	    // picked coin 
	    for(int i=0; i<m; i++) 
	        for(int j=S[i]; j<=n; j++) 
	            table[j] += table[j-S[i]]; 
	  
	    return table[n]; 
	} 
	
	public static void main(String args[]) {
		int a [] = {1,2,3};
		System.out.println(countWaysToMakeChange(a,4));
	}
}
