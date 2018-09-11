package LinKedList2;

import java.util.Scanner;

public class InsertRecursive {
	
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
	public static Node<Integer> insertRec(Node<Integer>head,int pos,int ele) {
		if(pos==0) {
			Node<Integer>newNode = new Node<Integer>(ele);
			newNode.next=head;
			head=newNode;
			return head;
		}
		if(head==null) {
			return head;
		}
		Node<Integer>newNode = insertRec(head.next,pos-1,ele);
		head.next = newNode;
		
		return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer>newNode = takeInput();
		print(insertRec(newNode,2,10));
	}

}
