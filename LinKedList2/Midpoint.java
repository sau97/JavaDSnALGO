package LinKedList2;
import java.util.Scanner;
public class Midpoint {
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
	public static int midpoint(Node<Integer>head){
		
		Node<Integer>doubl = head;
		int len = len(head);
		if(head==null)
			return 0;
		if(len==1)
			return head.data;
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
		return head.data;
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer>head = takeInput();
		print(head);
		System.out.println(midpoint(head));
	}

}
