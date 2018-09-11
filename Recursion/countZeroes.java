package Recursion;

public class countZeroes {

	public static int countZeroesRec(int input) {
		if(input == 0)
			return 0;
		int k = input%10;
		if(k==0)
			return 1+countZeroesRec(input/10);
		return countZeroesRec(input/10);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countZeroesRec(102040));
		
	}

}
