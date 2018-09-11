package Recursion;
import java.math.*;
public class GeometricSum {

	public static double findGeometricSum(int k) {
		if(k == 0)
			return 1;
		return (1/Math.pow(2, k))+findGeometricSum(k-1);
		//return 2 - Math.pow(0.5, k);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findGeometricSum(3));
	}

}
