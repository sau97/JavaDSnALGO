package Stacks;

public class StackArray {
	private int data[];
	private int top;
	  
	StackArray(){
	data = new int[10];
	top = -1;
	}
	public int top() throws StackEmptyException{
		if(size() == 0) {
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
			return data[top]; 
	}
	public void push(int ele) throws StackFullException {
		if(size() == data.length) {
//			StackFullException e = new StackFullException();
//			throw e;
			int a[] = new int [2*data.length];
			for(int i = 0;i<data.length;i++)
				a[i] = data[i];
			data = a;
//			data = new int [2*a.length];
//			for(int i = 0;i<a.length;i++)
//				data[i] = a[i];
		}
		
		
		data[top+1] =ele;
		top++;
	}
	public int size() {
		return top+1;
	}
	public boolean isEmpty() {
		return (top == -1);
	}
	public int pop() throws StackEmptyException{
		if(size()==0) {
			StackEmptyException e  =new StackEmptyException();
			throw e;
		}
		int ret  = data[top];
		top--;
		return ret;
	}
	
}
