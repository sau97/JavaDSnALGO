package LinkedList;
import java.util.Scanner;
public class LinkedListUse {
	public static void print(Node<Integer> head) {
		///Node<Integer> parse = head;
		while(head!=null) {
			System.out.print(head.data+" ");
			head = head.next;
		}
		System.out.println();
	}
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
	public static int length(Node<Integer>head) {
		int len=0;
		if(head == null)
			return 0;
		else
			while(head!=null)
			{
				head=head.next;
				len++;
			}
		return len;
	}
	
	public static Node<Integer> insert(Node<Integer>head, int data,int pos) {
		Node<Integer>temp=head,hold;
		if(pos == 0) {
			Node<Integer>newnode = new Node<Integer>(data);
			head = newnode;
			head.next = temp;
			return head;
 		}
		int len = length(head);
		if(pos > len)
			return head;
		for(int i=0;i<pos-1;i++) 
			temp = temp.next;
		hold = temp.next;
		Node <Integer> newnode = new Node<Integer>(data);
		temp.next = newnode;
		newnode.next = hold;
		return head;
		}
	public static void printIth(Node<Integer> head, int i) {
		if(head==null || i<0)
			return;
		Node<Integer> trail=head;
		int len=0;
		while(trail!=null) {
			trail=trail.next;
			len++;
		}
		if(i>len)
			return;
		for(int j=0;j<i;j++)
			head = head.next;
		System.out.println(head.data);
	}
	public static Node<Integer> deleteIthNode(Node<Integer> head, int i){
		if(i == 0)
		{
			if(length(head)==1)
				return null;
			head = head.next;
			return head;
		}
		if(i>length(head))
			return head;
		
		Node<Integer>temp = head;
		for(int j=0;j<i-1;j++)
			temp = temp.next;
		temp.next = temp.next.next;
		return head;
	}
	public static int indexOfNIter(Node<Integer> head, int n) {
		int ind=0;
		while(head!=null) {
			if(head.data == n)
				return ind;
			head=head.next;
			ind++;
		}
		return -1;
	}
	
	public static Node<Integer> append(Node<Integer> root, int n){
		
		Node<Integer>temp = root,temp1=root,newhead;
		int len=0;
		while(temp!=null)
		{
			temp = temp.next;
			len++;		
		}
		while(temp1.next!=null)
			temp1=temp1.next;
		
		System.out.println(len);
		
		int stop = len-n;
		temp=root;
		for(int i=0;i<stop-1;i++)
			temp=temp.next;
		newhead=temp.next;
		temp.next = null;
		temp1.next=root;
		return newhead;
	}
	public static Node<Integer> appendagain(Node<Integer> head,int n){
		Node<Integer> temp=head,parse=head,headnew;
		int len=0;
		while(temp.next!=null) {
			len++;
			temp=temp.next;
		}
		len=len+1;
		for(int i=1;i<len-n;i++) {
			parse=parse.next;
		}
		headnew = parse.next;
		parse.next=null;
		temp.next = head;
		return headnew;
	}

	public static void main(String[] args) {
//		
//		Node<Integer> node1 = new Node<>(10);
//		Node <Integer>node2 = new Node<Integer>(20);
//		Node<Integer> node3 = new Node<Integer>(30);
//		node1.next = node2;
//		node2.next=node3;
//		Node<Integer> head = node1;
//		//System.out.println(node3.next);
//		
//		print(head);
//		print(head);
		Node<Integer>head;
		Node<Integer> head1 = takeInput();
		//print(head1);
		//System.out.println(length(head1));
		//printIth(head1,3);
	//	head = insert(head1,3,5);
		//print(head);
//		head = deleteIthNode(head1,0);
//		print(head);
		//System.out.println(indexOfNIter(head1, 6));
		head1 = appendagain(head1,3);
		print(head1);
	}

}
