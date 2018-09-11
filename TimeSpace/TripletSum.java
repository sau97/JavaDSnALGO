package TimeSpace;
import java.util.Arrays;
public class TripletSum {
	public static void FindTriplet(int[] arr, int x) {
		if(arr.length<1 || arr.length>1000||x<1 ||x>100)
			return;
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++)
			for(int j = i+1;j<arr.length;j++)
				for(int k = j+1;k<arr.length;k++)
					if(arr[i]+arr[j]+arr[k]==x)
						System.out.println(arr[i]+" "+arr[j]+" "+arr[k]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,2,3,4,5,6,7};
		FindTriplet(a,12);

	}

}
