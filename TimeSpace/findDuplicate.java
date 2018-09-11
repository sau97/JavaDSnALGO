package TimeSpace;

public class findDuplicate {
	public static int duplicate(int[] arr) {
		int a[] = new int [arr.length-1];
		for(int i=0;i<arr.length;i++)
			a[arr[i]]++;
		for(int i=0;i<a.length;i++)
			if(a[i]==2)
				return i;
	return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {0,7,2,5,4,7,1,3,6};
		System.out.println(duplicate(a));
	}

}
