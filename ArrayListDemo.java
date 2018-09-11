package ArrayList;
import java.util.ArrayList;
public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> l1 = new ArrayList<>();
		System.out.println(l1.size());
		l1.add(10);
		l1.add(20);
		l1.add(25);
		l1.add(2, 50);
		System.out.println(l1.size());
		System.out.println(l1.get(3));
		for(int i=0;i<l1.size();i++)
			System.out.print(l1.get(i)+" ");
		System.out.println();
		l1.set(0,100);
		for (int i=0;i<l1.size();i++)
			System.out.print(l1.get(i)+" ");
		System.out.println();
		for( int ele :l1)
			System.out.print(ele+" ");
		}

}
