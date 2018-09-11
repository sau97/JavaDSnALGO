package TimeSpace;
import java.util.Arrays;
public class ArrayIntersection {
	public static void intersection(int[] arr1, int[] arr2) {
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int i=0,j=0;
		while(i<arr1.length&&j<arr2.length) {
			if(arr1[i]==arr2[j]) {
				System.out.println(arr1[i]);
				j++;
				i++;
				}
			else if(arr1[i]>arr2[j])
				j++;
			else if(arr1[i]<arr2[j])
				i++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {2,6,8,5,4,3};
		int b[] = {2,3, 4,7};
		intersection(a,b);
		}

}
