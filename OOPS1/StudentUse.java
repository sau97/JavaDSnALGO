package OOPS1;
import java.util.Scanner;
public class StudentUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s  =new Scanner(System.in);
		Student s1 = new Student("abc",123);
		s1.name = "ankush";
		//s1.SetRollnumber(123);
		Student s2 = new Student("def",456);
		//System.out.println(s1);
		System.out.println(s1.getRollNumber());
		s1.print();
		System.out.println(s1.getNumStudents());
		System.out.println(Student.getNumStudents());
	}

}
