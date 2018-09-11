package BinaryTrees;
import LinkedList.Node;

class PairOfNodeElem {
	Node<Integer> head;
	Node<Integer> tail;
	}
public class BinTreetosortedLL {
	
		public static Node<Integer> BSTToSortedLL(BinaryTreeNode<Integer> root){
		return helper(root).head;
		}
		private static PairOfNodeElem helper(BinaryTreeNode<Integer> root) {
		if(root == null) {
		PairOfNodeElem pair = new PairOfNodeElem();
		pair.head = null;
		pair.tail = null;
		return pair;
		}
		Node<Integer> nn = new Node<Integer>(root.data);
		PairOfNodeElem leftTree = helper(root.left);
		PairOfNodeElem rightTree = helper(root.right);
		PairOfNodeElem pair = new PairOfNodeElem();
		if(leftTree.head != null) {
		pair.head = leftTree.head;
		pair.tail = leftTree.tail;
		pair.tail.next = nn;
		pair.tail = nn;
		if(rightTree.head == null){
		return pair;
		}
		}
		if(rightTree.head != null && leftTree.head!=null) {
		pair.tail.next=rightTree.head;
		pair.tail = rightTree.tail;
		return pair;
		}
		if(rightTree.head != null && leftTree.head == null) {
		pair.head = nn;
		nn.next = rightTree.head;
		pair.tail = rightTree.tail;
		return pair;
		}
		else {
		pair.head = nn;
		pair.tail = nn;
		}
		return pair;
		}
		}

