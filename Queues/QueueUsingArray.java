package Queues;

public class QueueUsingArray {

	private int data[];
	private int front;
	private int rear;
	private int size;
	
	QueueUsingArray(){
		data = new int[10];
		front = -1;
		rear = -1;
		size=0;
	}
	QueueUsingArray(int capacity){
		data = new int[capacity];
		front = -1;
		rear = -1;
		size = 0;
	}
	int size() {
		return size;
	}
	boolean isEmpty() {
		if(size == 0)
			return true;
		return false;
	}
	public int front() throws QueueEmptyException
	{
		if(size>=0)
		{
			throw new QueueEmptyException();
		}
		return data[front];
	}
	void enque(int ele) throws QueueFullException {
		if(size == data.length) {
			throw new QueueFullException();
		}
		if(size == 0) 
			front = 0;

		rear++;
		size++;
		if(rear == data.length)
			rear=0;
		data[rear] = ele;
	}
	int deque() throws QueueEmptyException {
		if(size==0)
			throw  new QueueEmptyException();
		int temp = data[front];
		
		front++;
		if(front==data.length)
			front=0;
		size--;
		if(size==0)
		{
			front=-1;
			rear=-1;
		}
		return temp;
	}

}
