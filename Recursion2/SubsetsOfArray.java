package Recursion2;
import java.util.Arrays;
public class SubsetsOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {3,5,3,4,5,6,7,6,10,7,10};
		Arrays.sort(a);
		int i;
		for( i=0;i<a.length;i++) {
			if(a[i]==a[i+1])
				i++;
			else
				break;
		}
		System.out.println(a[i]);
	}

}
