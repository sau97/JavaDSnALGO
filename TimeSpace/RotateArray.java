package TimeSpace;
import java.util.Scanner;
public class RotateArray {
	
	public static int [] rotate(int[] arr, int d) {
		for(int i = 0;i<d;i++)
		{ 	
			int lastind = arr[arr.length-1];
			for(int j=0;j<arr.length-1;j++) {
				int crrind = (j+arr.length)%(arr.length);
				int prevind = (j+arr.length-1)%arr.length;
				int temp = arr[prevind];
				arr[prevind] = arr[crrind];
			}
			arr[arr.length-2]=lastind;
			}
		return arr;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int a[] = new int[n];
		for(int i=0;i<a.length;i++)
			a[i] = s.nextInt();
		int d = s.nextInt();
		a = rotate(a,2);
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
	}

}
