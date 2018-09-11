package Recursion;
import java.util.Scanner;
public class TowerOfHanoi {
	
	public static void towerOfHanoi(int disks,char source,char aux,char dest) {
		if(disks<=0)
			return;
		if(disks == 1) {
			System.out.println(source + " " + dest);
			return;}	
		towerOfHanoi(disks-1, source, dest, aux);
		towerOfHanoi(1, source, aux, dest);
		towerOfHanoi(disks-1, aux, source, dest);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner (System.in);
		int n =s.nextInt(); 
		towerOfHanoi(n,'a','b','c');
	}

}
