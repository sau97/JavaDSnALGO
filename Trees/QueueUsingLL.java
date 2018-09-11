package Trees;

public class QueueUsingLL<T> {
	
	private Node<T>front=null;
	private Node<T> rear=null;
	private static int size;
	
	public QueueUsingLL(){
		front=null;
		rear=null;
		size=0;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return (size==0);
	}
	
	public T front() throws QueueEmptyException {
		if(front==null)
			throw new QueueEmptyException();
		return front.data;
	}
	
	public void enqueue(T rootData) {
		if(front==null) {
			Node<T> newnode = new Node<T>(rootData);
			front=newnode;
			rear=newnode;
			size++;
		}
		else {
			Node<T>newnode = new Node<T>(rootData);
			rear.next=newnode;
			rear = newnode;
			size++;
		}
	}
	
	public T dequeue() throws QueueEmptyException{
		if(front==null && rear==null) {
			throw new QueueEmptyException();
		}
		else {
		T temp = front.data;
		front = front.next;
		size--;
		return temp;
		}
	}
	
	public static void main(String[]args) {
		QueueUsingLL<Integer> queue= new QueueUsingLL<>();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
	
		try {
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		}catch(Exception e) {
			
		}
	}
}