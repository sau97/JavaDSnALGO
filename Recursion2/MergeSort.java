package Recursion2;
//// CODE ISN'T CORRECT
public class MergeSort {
	public static int[] mergeSort(int a[]) {
		return sort(a,0,a.length);
	}
	public static int[] sort(int a[],int si,int ei) {
		if(si<ei)
		{
		int mid = (si+ei)/2;
		sort(a,si,mid);
		sort(a,mid+1,ei);
		merge(a,si,mid,ei);
		}
		return a;
	}
	public static int []merge(int a[],int si,int mi,int ei){
		
		int a1[] = new int [mi-si];
		int a2[] = new int [ei-mi];
		int arr[] = new int [ei-si];
		System.out.println("a.len = "+a.length + "  si ="+si+"  ei= "+ei + "  arr len" +arr.length);
		for (int i = 0;i<a1.length;i++)
			a1[i] = a[i+si];
		for(int i = 0;i<a2.length;i++)
			a2[i] = a[mi+i];
		int i=0,j=0;
		int k =0;
		while(i<a1.length&&j<a2.length) {
			if(a1[i]<a2[j]) {
				arr[k] = a1[i];
				i++;
				k++;
			}
			else {
				arr[k]=a2[j];
				j++;
				k++;
				}
		}
		if(i-1!=a1.length-1&&i-1<a1.length&&k<ei-si) {
			System.out.println("i="+i);
			for(int l = i;l<a1.length;l++)
			{
				arr[k] = a1[l];
				k++;
			}
		}
		else if(j-1!=a2.length-1&&j-1<a2.length&&k<ei-si) 
		{
			for(int l = j;l<a2.length && k<ei-si;l++) {
				arr[k] = a2[l];
				k++;
			}
		}
		return arr;
		
	}
	public static void main(String[]args) {
		int a[] = {1,3,5,6,8,2,4,7,9,10} ;
		//int b[] = merge(a,0,ei-si/2,ei-si);
		int b[] = sort(a,0,a.length);
		for(int i=0;i<b.length;i++)
			System.out.println(b[i]);
	}
}
