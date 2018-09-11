package LinKedList2;

import java.util.Scanner;

public class Reverse {
	
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
	public static Node<Integer> reverse(Node<Integer>head){
		Node<Integer> first=head,temp;
		Node<Integer> second = first.next;
		head.next=null;
		while(second!=null) {
		temp = second.next;
		second.next=first;
		first = second;
		second = temp;

		}
		return first;
	}
	public static Node<Integer> reverseRec(Node<Integer> head){
		if(head.next==null || head==null)
			return head;

		 Node<Integer>finalHead = reverseRec(head.next); // aage ka kaam hogya
		 Node<Integer> temp = finalHead;
		 while(temp.next!=null)
			 temp=temp.next;
		 temp.next=head;
		 head.next=null;
		 return finalHead;
	}
	// BETTER APPROACH FOR REVERSE REVERSAL OF LL RECURSIVE APPROACH
	public static doubleNode <Integer>reverseLLBetter(Node<Integer>head){
		
		if(head==null||head.next==null) {
			doubleNode<Integer> dbl = new doubleNode<>();
			dbl.head=head;
			dbl.tail=head;
			return dbl;
			}
		doubleNode<Integer> dbl =reverseLLBetter(head.next);
		dbl.tail.next = head;
		head.next=null;
		
		doubleNode<Integer> ans = new doubleNode<>();
		ans.head = dbl.head;
		ans.tail = head;
		return ans;
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = takeInput();
//		Node<Integer> newhead = reverse(head);
//		print(newhead);
//		Node<Integer>rev = reverseRec(newhead);
//		print(rev);
		doubleNode<Integer> newHead = reverseLLBetter(head);
		print(newHead.head);
	}

}
