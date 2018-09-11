package LinKedList2;

import java.util.Scanner;

public class ReverseLL3 {
	
	public static Node<Integer> takeInput(){
		Scanner s = new Scanner(System.in);
		Node<Integer>head = null,tail=null;
		int n = s.nextInt();
		while(n!=-1) {
			Node<Integer>newNode = new Node<>(n);
			if(head==null) {
				head = newNode;
				tail = newNode;
			}
			tail.next = newNode;
			tail = tail.next;
			n  =s.nextInt();
		}
		return head;
	}
	public static void print(Node<Integer>head) {
		while(head!=null) {
			System.out.print(head.data+" ");
			head=head.next;
		}
		System.out.println();
	}
	public  static Node<Integer> reverse(Node<Integer> head){
		if(head==null || head.next==null)
			return head;
		Node<Integer> reversedTail = head.next;
		Node<Integer> smallHead = reverse(head.next);
		reversedTail.next=head;
		head.next=null;
		
		return smallHead;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
