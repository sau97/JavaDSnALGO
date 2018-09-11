package Recursion2;
// NOT WORKING YET
public class Quick {
	public static void quicksort(int[]input){
	sort(input,0,input.length-1);
		//for(int i=0;i<b.length;i++)
			//System.out.println(b[i]);
	}
	public static void sort(int arr[],int si,int ei) {
		if(si>=ei)
			return;
		int pivotpos = partition(arr,si,ei);
		 sort(arr,si,pivotpos-1);
	     sort(arr,pivotpos+1,ei);
	}
	public static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high]; 
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;
 
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a []= {1,2,3,4,5};
		quicksort(a);
		for(int i=0;i<a.length;i++)
			System.out.println(a[i]);

	}

}
