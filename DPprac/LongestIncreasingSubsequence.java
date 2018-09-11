package DPprac;

public class LongestIncreasingSubsequence {
	
public static int lis(int arr[]) {
		
	int lis[] = new int [arr.length];
	int max = 0;
	for(int i=0;i<arr.length;i++)
		lis[i]=1;
	for(int i = 0;i<arr.length;i++) {
		for(int j=i;j>=0;j--) {
			if(arr[i]>arr[j]&&lis[i]<lis[j]+1)
				lis[i] = lis[j]+1;
		}
	}
	for(int i = 0;i<lis.length;i++)
		if(lis[i]>max)
			max = lis[i];
	return max;

	}	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr = {10, 22, 9, 33, 21, 50, 41, 60};
		System.out.println(lis(arr));
	}

}
