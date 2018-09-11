package LinKedList2;

import java.util.Scanner;

public class MergeSort {
	
	public static int len(Node<Integer>head) {
		int l = 0;
		if(head==null)
			return 0;
		if(head.next==null)
			return 1;
		while(head!=null)
		{
			l++;
			head=head.next;
		}
		return l;
	}
	public static Node<Integer> midpoint(Node<Integer>head){
		
		Node<Integer>doubl = head;
		int len = len(head);
		if(head==null)
			return head;
		if(len==1)
			return head;
		if(len%2==1)
		while(doubl.next!=null) {
			head=head.next;
			doubl = doubl.next;
			if (doubl.next == null)
					break;
			doubl = doubl.next;
		}
		else
			while(doubl.next.next!=null) {
				head=head.next;
				doubl = doubl.next;
				if (doubl.next == null)
						break;
				doubl = doubl.next;
			}
		return head;
	}
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
	public static Node<Integer>msort(Node<Integer>head){
		if(head==null||head.next==null)
			return head;
		Node<Integer> mid = midpoint(head);
		Node<Integer> next = mid.next;
		mid.next=null;
		Node<Integer>left = msort(head);
		Node<Integer>right = msort(next);
		Node<Integer> sorted = Merge(left,right);
		return sorted;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer>head = takeInput();
		print(head);
		Node<Integer>sorted = msort(head);
		print(sorted);
	}

}
