package BinaryTrees;

import Recursion2.BinarySearch;
import Trees.QueueEmptyException;
import Trees.QueueUsingLL;

public class BinarySearchTree {
	private BinaryTreeNode<Integer>root;
	
	public boolean hasData(int data) {
		return hasDataHelper(root,data);
	}
	private boolean hasDataHelper(BinaryTreeNode<Integer>root,int data) {
		if(root == null)
			return false;
		if(root.data == data)
			return true;
		else if(data<root.data)
				return hasDataHelper(root.left, data);
		else
			return hasDataHelper(root.right, data);
		}
	private BinaryTreeNode<Integer>insertData(BinaryTreeNode<Integer>root,int data){
		if(root == null) {
			BinaryTreeNode<Integer>newnode = new BinaryTreeNode<Integer>(data);
			return newnode;
		}
		if(root.data>data) {
			root.left=insertData(root.left, data);
		}
		else {
			root.right = insertData(root.right, data);
		}
		return root;
	}
	public void insertData(int data) {
		root = insertData(root,data);
	}
	public void deleteData(int data) {
		root= deleteData(data,root);
	}
	private BinaryTreeNode<Integer> deleteData(int data, BinaryTreeNode<Integer> root) {
		if (root == null) {
			return null;
		}
		if (data < root.data) {
			root.left = deleteData(data, root.left);
			return root;
		} else if (data > root.data) {
			root.right = deleteData(data, root.right);
			return root;
		} else {
			if (root.left == null && root.right == null) {
				return null;
			} else if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			} else {
				BinaryTreeNode<Integer> minNode = root.right;
				while (minNode.left != null) {
					minNode = minNode.left;
				}
				root.data = minNode.data;
				root.right = deleteData(minNode.data, root.right);
				return root;
			}
		}
		
	}
	public void printTree() {
		printTree(root);
	}
	
	private void printTree(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		String toBePrinted = root.data + "";
		if (root.left != null) {
			toBePrinted += "L:" + root.left.data + ",";
		}
		
		if (root.right != null) {
			toBePrinted += "R:" + root.right.data;
		}
		System.out.println(toBePrinted);
		printTree(root.left);
		printTree(root.right);
	}
	
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinarySearchTree obj = new BinarySearchTree();
		obj.insertData(10);
		obj.insertData(20);
		obj.insertData(5);
		obj.insertData(15);
		obj.insertData(3);
		obj.insertData(7);
		obj.deleteData(10);
		obj.printTree();
	}

}
