package Trees;
import java.util.Scanner;
import java.util.*;
public class TreeUse {
	
	public static TreeNode<Integer> takeInput(Scanner s) {
		
		int n;
		System.out.println("Enter data for next node");
		n = s.nextInt();
		TreeNode <Integer> root = new TreeNode<>(n);
		System.out.println("Enter the number of children for "+n);
		int childcount = s.nextInt();
		for(int i=0;i<childcount;i++) {
			TreeNode<Integer>child = takeInput(s);
			root.children.add(child);
		}
		return root;
	}
	public static void print(TreeNode<Integer>root) {
		String s = root.data +":";
		for(int i=0;i<root.children.size();i++) {
			s = s + root.children.get(i).data + ",";
		}
		System.out.println(s);
		for(int i=0;i<root.children.size();i++) {
			print(root.children.get(i));
		}
	}
	
	public static TreeNode<Integer> takeInputLevelWise(){
		Scanner s = new Scanner(System.in);
		System.out.println("enter root data");
		int rootData = s.nextInt();
		TreeNode<Integer>root = new TreeNode<Integer>(rootData);
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		pendingNodes.enqueue(root);
		while(!pendingNodes.isEmpty()) {
			try {
				TreeNode<Integer>frontNode = pendingNodes.dequeue();
				System.out.println("Enter number of children of "+frontNode.data);
				int numChildren = s.nextInt();
				for(int i=0;i<numChildren;i++) {
					System.out.println("Enter "+(i+1) +"th child of "+frontNode.data);
					int child = s.nextInt();
					TreeNode<Integer> childNode = new TreeNode<Integer>(child);
					frontNode.children.add(childNode);
					pendingNodes.enqueue(childNode);
				}
			} catch (QueueEmptyException e) {
				return null;
			}
		}
		return root;
		
	}
	
	public static void printLevelWise(TreeNode<Integer>root) throws QueueEmptyException {
		QueueUsingLL<TreeNode<Integer>>pendingNodes = new QueueUsingLL<>();
		pendingNodes.enqueue(root);
		while(!pendingNodes.isEmpty()) {
			TreeNode<Integer> front= pendingNodes.dequeue();
			int numChild = front.children.size();
			int a= front.data.intValue();
			System.out.print(a +" " );
//			System.out.print(a);
			for(int i=0;i<numChild;i++) {
				System.out.print(front.children.get(i)+",");;
				pendingNodes.enqueue(front.children.get(i));
			}
			System.out.println();
		}
	}
	
	public static int numNodes(TreeNode<Integer>root) {
		int count = 1;
		for(int i = 0;i<root.children.size();i++) {
			count += numNodes(root.children.get(i));
		}
		return count;
	}
	
	public static  int sumosAllNode(TreeNode<Integer>root) {
		int sum=root.data;
		for(int i = 0;i<root.children.size();i++) {
			sum += sumosAllNode(root.children.get(i));
		}
		return sum;
	}
	
	public static int largest(TreeNode<Integer>root) {
		
		if(root==null)
			return Integer.MIN_VALUE;
		int ans = root.data;
		for(int i=0;i<root.children.size();i++) {
			int childLargest = largest(root.children.get(i));
			if(childLargest>ans)
				ans = childLargest;
		}
		return ans;
	}
	
	public static int height(TreeNode<Integer>root) {
	
		if(root==null)
			return 0;
		if(root.children.size() == 0)
			return 1;
		int h=0;

		for(int i=0;i<root.children.size();i++) {
			h = Math.max(h, height(root.children.get(i)));
			
		}
	 return h+1;
	}
	
	public static void printAtK(TreeNode<Integer> root,int k) {
		if(k==0) {
			System.out.println(root.data);
			return;
		}
		for(int i=0;i<root.children.size();i++) {
			printAtK(root.children.get(i),k-1);
		}
	}

	public static void postorder(TreeNode<Integer>root) throws QueueEmptyException {
		if(root==null)
			return;
		for(int i=0;i<root.children.size();i++) {
			postorder(root.children.get(i));
		}
		System.out.print(root.data+" ");
	}

	public static void preorder(TreeNode<Integer>root) {
		if(root==null)
			return;
		System.out.print(root.data+" ");
		for(int i=0;i<root.children.size();i++)
			preorder(root.children.get(i));
	}

	public static int countLeafNodes(TreeNode<Integer> root){

		if(root==null)
			return 0;
		int num=0;
		if(root.children.size()==0)
			return 1;
		for(int i=0;i<root.children.size();i++) {
			num += countLeafNodes(root.children.get(i));
		}
		return num;
	}
	
	public static boolean checkIfContainsX(TreeNode<Integer> root, int x){
		boolean pres=false;
		if(root==null) 
			return false;
		if(root.data==x) 
			return true;
		
		for(int i=0;i<root.children.size();i++)
		{	
			
			pres= checkIfContainsX(root.children.get(i), x);
			if(pres == true)
				return pres;
		}
		return pres;
		
	}

	public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
		
		
		return helper(root,0,null);
	}
	public static TreeNode<Integer> helper(TreeNode<Integer>root,int maxsum,TreeNode<Integer>that) {
		if(root==null)
			return null;
		
		int sum = 0;
		
		
		sum = root.data;
		for(int i=0;i<root.children.size();i++) {
			sum += root.children.get(i).data;
		}
		if(maxsum<sum) {
			maxsum= sum;
			that = root;
			//System.out.println("maxsum:" +maxsum+" sum:"+sum +" root:" +that.data);
		}
		for(int i=0;i<root.children.size();i++)
			that = helper(root.children.get(i),maxsum,that);
		
		
		return that;
	}
	
	
	public static int numNodeGreater(TreeNode<Integer> root,int x) {
		if(root==null)
			return 0;
		int count = 0;
		if(root.data>x)
			count++;
		for(int i=0;i<root.children.size();i++) {
				count +=numNodeGreater(root.children.get(i), x);
		}
		return count;
	}
	
	public static void main(String[] args) throws QueueEmptyException {
		//Scanner s  =new Scanner(System.in);
		//TreeNode<Integer> root = takeInput(s);
		TreeNode<Integer> root = takeInputLevelWise();
		print(root);
		//printLevelWise(root);
		System.out.println(numNodes(root));
		System.out.println("sum:" +sumosAllNode(root));
		System.out.println("largest "+largest(root));
		System.out.println("num gt than 2 :"+numNodeGreater(root, 2));
		System.out.println("height: "+height(root));
		System.out.println("Printing elements at level 2");
		printAtK(root, 2);
		System.out.println("Num leaf Nodes: "+countLeafNodes(root));
		System.out.println("PreOrder Traversal");
		preorder(root);
		System.out.println();
		System.out.println("Post Order Traversal");
		postorder(root);
		System.out.println();
		System.out.println("check if it has 1"+checkIfContainsX(root, 1));
		System.out.println();
		System.out.println("Node with MaxSum"+maxSumNode(root).data);
//		TreeNode<Integer> root = new TreeNode<>(4);
//		TreeNode<Integer> node1 = new TreeNode<>(2);
//		TreeNode<Integer> node2 = new TreeNode<>(3);
//		TreeNode<Integer> node3 = new TreeNode<>(5);
//		TreeNode<Integer> node4 = new TreeNode<>(6);
//		
//		root.children.add(node1);
//		root.children.add(node2);
//		root.children.add(node3);
//		root.children.add(node4);
//		System.out.println(root);
	}

}
