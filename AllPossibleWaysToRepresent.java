package DPprac;

public class AllPossibleWaysToRepresent {
	public static int allWays(int x, int n) {
       
		return count(x,x,0,n);

    }
	static int res=0;
	public static int count(int num,int x,int k,int n) {
		if(x==0)
			res++;
		for(int i=k+1;i<=(int)Math.pow(num, (float)1/n);i++) {
			int a = x - (int)Math.pow(i, n);
			if(a>=0)
				count(num,x-(int)Math.pow(i, n),i,n);
		}
		return res;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("count:"+allWays(100,2));
	}

}
