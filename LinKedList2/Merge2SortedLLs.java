package LinKedList2;

import java.util.Scanner;

public class Merge2SortedLLs {
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
	public static Node<Integer> Merge(Node<Integer>head1,Node<Integer>head2){
		Node<Integer>head=null,tail=null;
		
		
		while(head1!=null && head2!=null) {
			if(head1.data<=head2.data) {
				if(head == null) {
					head = new Node<Integer>(head1.data);
					head1= head1.next;
					tail  =head;
				}
				else {
				Node <Integer> newNode= new Node<>(head1.data);
				tail.next = newNode;
				tail = newNode;
				head1=head1.next;
				}
			}
			else {
				if(head == null) {
					head = new Node<Integer> (head2.data);
					head2 = head2.next;
					tail = head;
				}
				else {
				Node<Integer>newNode = new Node<>(head2.data);
				tail.next=newNode;
				tail  =newNode;
				head2=head2.next;
				}
			}
			
		}
		if(head1!=null)
			tail.next = head1;
		if(head2!=null)
			tail.next=head2;
			
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head1 = takeInput();
		print(head1);
		Node<Integer> head2 = takeInput();
		print(head2);
		Node<Integer>head = Merge(head1,head2);
		print(head);
	}

}
