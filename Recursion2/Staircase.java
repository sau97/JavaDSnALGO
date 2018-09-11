package Recursion2;

public class Staircase {
	public static int staircase(int num) {
		if(num==0 || num==1)
			return 1;
		if(num==2)
			return 2;
		return staircase(num-1)+staircase(num-2)+staircase(num-3);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(staircase(4));
	}

}
