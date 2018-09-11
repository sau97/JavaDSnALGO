package Stacks;

public class StackUsingLL <T>{
	
	private Node <T> head;
	private int size;
	
	public StackUsingLL() {
		head = null;
		size = 0;
	}
	int size() {
		return size;
	}
	public T top() throws Exception{
		if(head == null) {
			throw new StackEmptyException();
			}
		return head.data;
	}
	boolean isEmpty() {
		if(head == null)
			return true;
		return false;
	}
	void push (T element) {
		if(head == null) {
			Node<T> nn = new Node<T>(element);
			head = nn;
		}
		else {
			Node<T>nn = new Node<T>(element);
			nn.next = head;
			head = nn;
			}
		size ++;
	}
	T pop() throws Exception {
		if(head == null) {
		throw new StackEmptyException();
		}
		T data = head.data;
		head = head.next;
		size--;
		return data;

	}
}
