package OOPS1;

public class Student {
	public String name;
	//final data members can be initialized as soon as created
	private final int rollNumber ;
	private static int numStudents;
	public Student(String name, int rollNumber) {
		this.name = name;
		this.rollNumber = rollNumber;
		numStudents++;
	}
//	public void SetRollnumber(int rn) {
	//	if(rn<0)
		//	return;
		//rollNumber = rn;
	//}
	public int getRollNumber() {
		return rollNumber;
	}
	public void print() {
		System.out.println("NAME:"+name+" roll:"+rollNumber);
	}
	
	public static int getNumStudents() {
		return numStudents;
	}
}
