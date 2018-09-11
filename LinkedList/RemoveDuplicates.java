package LinkedList;
import java.util.Scanner;
public class RemoveDuplicates {
	public static Node<Integer> takeInput(){
		Node<Integer> head = null,tail=null;
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		while(n!=-1) {
			Node<Integer>newNode = new Node<>(n);
			if(head==null) {
				head = newNode;
				tail=newNode;}
			else
			{
				tail.next = newNode;
				tail = tail.next;//tail=newNode;
			}
			n = s.nextInt();
		}
		return head;
	}
	public static Node<Integer> removeDuplicates(Node<Integer>head){
		Node<Integer> tail = head,nextnext;
		while(tail.next!=null) {
			if((long)tail.data==(long)tail.next.data) {
				nextnext = tail.next.next;
				tail.next = null;
				tail.next = nextnext;
			}
			else
				tail = tail.next;
		}
		return head;
	}
	public static void print(Node<Integer> head) {
		///Node<Integer> parse = head;
		while(head!=null) {
			System.out.print(head.data+" ");
			head = head.next;
		}
		System.out.println();
	}
	public static void printReverse(Node<Integer> head) {
		if(head == null)
			return;
		printReverse(head.next);
		System.out.print(head.data+" ");
		
	}
	public static boolean isPalindrome_2(Node<Integer> head) {
		
		Node<Integer> head2 = null,temp=head;
		int i=0;
		while(temp!=null) {
			head2 = insertathead(head2,temp.data);
			temp=temp.next;
		}

		while(head!=null) {
			if(head.data!=head2.data)
				return false;
			head=head.next;
			head2=head2.next;
		}
		return true;
	}
	public static Node<Integer> insertathead(Node<Integer>head,int element){
		Node<Integer> newNode = new Node<Integer>(element);
		newNode.next=head;
		head=newNode;
		return newNode;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = takeInput();
//		Node<Integer>head1;
//		System.out.println("hello");
//		head1 = removeDuplicates(head);
//		System.out.println("hello again");
//		print(head1);
		//printReverse(head);
		System.out.println(isPalindrome_2(head));;
	}

}
