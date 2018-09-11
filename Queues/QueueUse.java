package Queues;

public class QueueUse {

	public static void main(String[] args) {
		QueueUsingArray queue = new QueueUsingArray();
		for (int i=1;i<=5;i++) {
			try {
			queue.enque(i);
			}catch(QueueFullException e){
				
			}
		}
		while(!queue.isEmpty()) {
			try {
				System.out.println(queue.deque());
			} catch(QueueEmptyException e) {
				
			}
		}
	}

}
