package BinaryTrees;
import LinkedList.Node;
import Trees.QueueEmptyException;
import Trees.QueueUsingLL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreeUSE2 {
	
	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		if(root==null)
			return;
		QueueUsingLL<BinaryTreeNode<Integer>>queue = new QueueUsingLL<>();
		BinaryTreeNode<Integer> nullNode = new BinaryTreeNode<>(Integer.MIN_VALUE);;
		queue.enqueue(root);
		queue.enqueue(nullNode);
		while(queue.size()!=1) {
			BinaryTreeNode<Integer>temp=null;
			try {
				temp = queue.dequeue();
			} catch (QueueEmptyException e) {
			}
			if(temp==nullNode) {
				queue.enqueue(nullNode);
				continue;
			}
			//System.out.println(temp.data);
			if(temp==null)
				continue;
			if(temp.left==null && temp.right==null)
				System.out.println(temp.data + ":"+"L:-1,R:-1");
			if(temp.left==null && temp.right != null)
				System.out.println(temp.data+":"+"L:-1,"+"R:"+temp.right.data);
			if(temp.left!=null && temp.right==null)
				System.out.println(temp.data+":"+"L:"+temp.left.data+",R:-1");
			else if(temp.left!=null && temp.right!=null)
			System.out.println(temp.data+":"+"L:"+temp.left.data + ",R:"+temp.right.data);
			queue.enqueue(temp.left);
			queue.enqueue(temp.right);
		}
		
	}
public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr){
		
		return constructBST(arr,0,arr.length-1);
	}
	public static BinaryTreeNode<Integer>constructBST(int []a,int si,int ei){
		
		if(si>ei)
			return null;
		int mid = (ei+si)/2;
		BinaryTreeNode<Integer>root = new BinaryTreeNode<Integer>(a[mid]);
		
		root.left = constructBST(a, si, mid-1);
		root.right = constructBST(a, mid+1, ei);
		
		return root;
	}
	public static void inorder(BinaryTreeNode<Integer>root) {
		if(root==null)
			return;
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}

	
	public static void printLL(Node<Integer>head) {
		System.out.println();
		while(head!=null) {
			System.out.print(head.data+" ");
			head = head.next;
		}
	}
	public static ArrayList<Integer>getRootToNodePath(BinaryTreeNode<Integer>root,int data){
		if(root == null)
			return null;
		if(root.data == data) {
			ArrayList<Integer>output = new ArrayList<Integer>();
			output.add(root.data);
			return output;
		}
		ArrayList<Integer>leftOutput = getRootToNodePath(root.left, data);
		if(leftOutput!=null) {
			leftOutput.add(root.data);
			return leftOutput;
		}
		ArrayList rightOutput = getRootToNodePath(root.right,data);
		if(rightOutput!=null) {
			rightOutput.add(root.data);
			return rightOutput;
		}
		else
			return null;
	}
	public static ArrayList<Integer> findPath(BinaryTreeNode<Integer> root, int data){
	// for BST
		if(root == null)
			return null;
		if(root.data == data) {
			ArrayList<Integer> out = new ArrayList<Integer>();
			out.add(root.data);
			return out;
		}
		if(data<root.data) {
			ArrayList leftOutput = findPath(root.left,data);
			if(leftOutput!=null) {
				leftOutput.add(root.data);
				return leftOutput;
			}
		}
		if(root.data<data) {
			ArrayList<Integer>rightOutput = findPath(root.right,data);
			if(rightOutput!=null){
				rightOutput.add(root.data);
				return rightOutput;
			}
		}
		return null;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,2,3,4,5,6,7};
		BinaryTreeNode<Integer> root = SortedArrayToBST(a);
		//printLevelWise(root);
		//inorder(root);
	
//		ArrayList ans = getRootToNodePath(root, 7);
//		for(int i=0;i<ans.size();i++)
//			System.out.print(ans.get(i)+" ");
		ArrayList<Integer>ansbst = findPath(root,1);
		if(ansbst!=null)
		for(int i=0;i<ansbst.size();i++)
			System.out.print(ansbst.get(i)+" ");
		
	}

}
