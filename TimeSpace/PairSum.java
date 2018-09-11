package TimeSpace;
import java.util.Arrays;
public class PairSum {
	public static void pairSum(int[] arr, int num) {
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++)
			for(int j=i+1;j<arr.length;j++)//j=i+1
			{
				if(arr[j]==num-arr[i]) {
					int n = arr[j],m = arr[i];
					if(n<m)
						System.out.println(n+" "+m);
					else
						System.out.println(m+" "+n);
				}
			}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a [] = {1,3,6,2,5,4,3,2,4};
		pairSum(a,7);
	}

}
