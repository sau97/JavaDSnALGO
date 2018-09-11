package BinaryTrees;
import java.util.Queue;
import java.util.Scanner;
import Trees.QueueUsingLL;
import Trees.Node;
import Trees.QueueEmptyException;
public class BinaryTreeUse {
	public static BinaryTreeNode<Integer> takeInput(Scanner s){
		System.out.println("enter root data");
		int rootdata =  s.nextInt();
		if(rootdata==-1)
			return null;
		BinaryTreeNode<Integer>root = new BinaryTreeNode<Integer>(rootdata);
		root.left = takeInput(s);
		root.right = takeInput(s);
		return root;
	}
	public static void printTree(BinaryTreeNode<Integer>root) {
		if(root==null)
			return ;
		String s = root.data +":";
		if(root.left!=null)
			s += "L"+root.left.data+",";
		if(root.right!=null)
			s += " R" +root.right.data; 
		System.out.println(s);
		printTree(root.left);
		printTree(root.right);
	}
	
	public static boolean isBST(BinaryTreeNode<Integer> root) {
		
	      if(root == null)
	          return true;
	      
	      int leftMax = maximum(root.left);
	      int rightMin = minimum(root.right);
	      
	      if(root.data<=leftMax || root.data>rightMin)
	        return false;
	      boolean isleftBST = isBST(root.left);
	      boolean isrightBST = isBST(root.right);
	      
	      if(isleftBST && isrightBST)
	        return true;
	      else
	        return false;
	      
			
		}
	public static int maximum(BinaryTreeNode<Integer> root){
	    
	    if(root == null)
	      return Integer.MIN_VALUE;
	    
		return Math.max(root.data,Math.max(maximum(root.left),maximum(root.right)));  
	  }
	public static int minimum(BinaryTreeNode root){
	    if(root == null)
	      return Integer.MAX_VALUE;
	    return Math.min((int) root.data,Math.min(minimum(root.left),minimum(root.right)));
	  }
	
	public static Pair<Boolean,Pair<Integer,Integer>> isBST2(BinaryTreeNode<Integer>root){
		
		if(root == null)
		{
			Pair<Boolean,Pair<Integer,Integer>> output = new Pair<>();
			output.first=true;
			output.second = new Pair<Integer,Integer>();
			output.second.first = Integer.MAX_VALUE;
			output.second.second=Integer.MIN_VALUE;
			return output;
		}
		Pair<Boolean,Pair<Integer,Integer>> leftOutput = isBST2(root.left);
		Pair<Boolean,Pair<Integer,Integer>> rightOutput = isBST2(root.right);
		
		int min = Math.min(root.data, Math.min(leftOutput.second.first, rightOutput.second.first));
		int max = Math.max(root.data, Math.max(leftOutput.second.second, rightOutput.second.second));
		
		boolean isBST = (root.data>=leftOutput.second.second)&& (root.data<rightOutput.second.first)
								&& (leftOutput.first)&&(rightOutput.first);
		
			Pair<Boolean, Pair<Integer,Integer>> output = new Pair<>();
			output.first = isBST;
			output.second.first = min;
			output.second.second = max;
			
			return output;
	}
	
	public static boolean isBST3(BinaryTreeNode<Integer>root,int min,int max) {
		if(root == null)
			return true;
		if(root.data<min || root.data>max)
			return false;
		boolean isLeftOK = isBST3(root.left,min,root.data-1);
		boolean isRightOK = isBST3(root.right,root.data,max);
		return isLeftOK && isRightOK;
	}
	

	public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr){
		
		return constructBST(arr,0,arr.length);
	}
	public static BinaryTreeNode<Integer>constructBST(int []a,int si,int ei){
		
		if(si>=ei)
			return null;
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(a[(si-ei)/2]);
		root.left = constructBST(a,0,(si-ei)/2-1);
		root.right = constructBST(a,(si-ei)/2+1,ei);
		
		return root;
	}


	public static BinaryTreeNode<Integer> takeInputLevelWise(){
		Scanner s = new Scanner(System.in);
		QueueUsingLL<BinaryTreeNode<Integer>> queue = new QueueUsingLL<>();
		System.out.println("Enter root data");
		int rootdata = s.nextInt();
		if(rootdata ==-1)
			return null;
		BinaryTreeNode<Integer>root = new BinaryTreeNode<Integer>(rootdata);
		queue.enqueue(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode<Integer> front=null;
			try {
			front = queue.dequeue();}catch(Exception e) {}
			System.out.println("Enter left child of "+front.data);
			int left = s.nextInt();
			if(left!=-1) {
			BinaryTreeNode<Integer>leftChild = new BinaryTreeNode<Integer>(left);
			queue.enqueue(leftChild);
			front.left = leftChild;
			}
			System.out.println("Enter right child of "+front.data);
			
			int right = s.nextInt();
			if(right!=-1) {
			BinaryTreeNode<Integer>rightChild = new BinaryTreeNode<Integer>(right);
			queue.enqueue(rightChild);
			front.right=rightChild;
			}
		}
		return root;
	}
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
	public static int numNode(BinaryTreeNode<Integer>root) {
		int count=0;
		if(root==null)
			return 0;
		else 
		count++;
		count += numNode(root.left);
		count+= numNode(root.right);
		return count;
	}
	/*public static int numNode(BinaryTreeNode<Integer>root) {
		int count=1;
		if(root==null)           Does same task
			return 0;
		count += numNode(root.left);
		count+= numNode(root.right);
		return count;
	 */
	public static boolean isNodePresent(BinaryTreeNode<Integer> root,int x){
		if(root==null)
			return false;
		boolean a = false;
		boolean ans = false;
		if(root.data==x)
		{
			a = true;
			System.out.println("in here");
			ans = a;
		}
		a = isNodePresent(root.left, x);
		if(ans == false)
			ans = a;
		a = isNodePresent(root.right, x);
		if(ans == false)
			ans = a;
		return ans;
	}
	public static int height(BinaryTreeNode<Integer> root) {
		int hRight = 1;
		int hLeft = 1;
		if(root==null)
			return 0;
		hRight += height(root.right);
		hLeft += height(root.left);
		return Math.max(hRight, hLeft);
		}
	
	public static void inorder(BinaryTreeNode<Integer>root) {
		if(root==null)
			return;
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	
	public static void preOrder(BinaryTreeNode<Integer> root) {
		if(root==null)
			return;
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
		
	}
	public static void postOrder(BinaryTreeNode<Integer> root) {
		if(root==null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data +" ");
		
	}
	
	public static void mirror(BinaryTreeNode<Integer> root){
		
		root = helperMirror(root);

	}
	public static BinaryTreeNode<Integer>helperMirror(BinaryTreeNode<Integer>root){
		if(root==null)
			return null;
		BinaryTreeNode<Integer>left = helperMirror(root.left);
		BinaryTreeNode<Integer>right = helperMirror(root.right);
		root.left = right;
		root.right = left;
		return root;
	}
	public static int diameter(BinaryTreeNode<Integer>root) {

		if(root==null)
			return 0;
		int option1 = height(root.right) + height(root.left);
		int option2 = diameter(root.left);
		int option3 = diameter(root.right);
		
		return Math.max(option3, Math.max(option1, option2));
		
	}
	
	public static Pair<Integer,Integer> heightDiameter(BinaryTreeNode<Integer>root){
		if(root==null)
			{
			Pair<Integer,Integer> output = new Pair<>();
			output.first=0;
			output.second=0;
			return output;
			}
		Pair<Integer,Integer>lo = heightDiameter(root.left);
		Pair<Integer,Integer>ro = heightDiameter(root.right);
		int height = 1+Math.max(lo.first, ro.first);
		int option1 = lo.first+ro.first;
		int option2 = lo.second;
		int option3 = ro.second;
		int dia =  Math.max(option3, Math.max(option1, option2));
		Pair<Integer,Integer> output = new Pair<>();
		output.first = height;
		output.second = dia;
		return output;
	}

	public static BinaryTreeNode<Integer> helpMirror(BinaryTreeNode<Integer> root){
		if(root==null)
			return null;
		if(root.left!=null && root.right!=null) {
		BinaryTreeNode<Integer> temp = root.left;
		root.left = root.right;
		root.right = temp;
		}
		if(root.left==null && root.right!=null) {
			root.left=root.right;
			root.right=null;
		}
		if(root.left!=null && root.right==null) {
			root.right=root.left;
			root.left=null;
		}
		helpMirror(root.left);
		helpMirror(root.right);
		return root;
	}
	
	public static BinaryTreeNode<Integer> getTreeFromPreorderAndInorder(int[] pre,int[] in){

		return constructTreePreIn(pre,in,0,pre.length-1,0,in.length-1);
		
	}
	public static BinaryTreeNode<Integer> constructTreePreIn(int pre[],int in[],int preStart,int preEnd,int inStart,int inEnd){
		
		if(preStart>preEnd || inStart>inEnd)
			return null;
		int rootData = pre[preStart];
		BinaryTreeNode<Integer>root = new BinaryTreeNode<Integer>(rootData);
		int ind=0;
		for(int i=0;i<in.length;i++)
			if(rootData == in[i]) {
				ind = i;
				break;
			}
		root.left = constructTreePreIn(pre, in, preStart+1, preStart+(ind-inStart), inStart, ind-1);
		root.right = constructTreePreIn(pre, in, preStart+ind-inStart+1, preEnd, ind+1, inEnd);
		
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner s = new Scanner(System.in);
//		BinaryTreeNode<Integer>root = takeInputLevelWise();
//		printTree(root);
//		printLevelWise(root);
//		System.out.println("NodeCount:"+numNode(root));
//		System.out.println("IS 2 present "+isNodePresent(root, 2));
//		System.out.println("Height"+height(root));
//		System.out.println("Mirror");
//		mirror(root);
//		System.out.println("Diameter : "+diameter(root));
//		System.out.println("Height:"+heightDiameter(root).first+"dia"+heightDiameter(root).second);
//		System.out.print("Inorer:");
//		inorder(root);
//		System.out.println();
//		System.out.print("Preorder:");
//		preOrder(root);
//		System.out.println();
//		System.out.print("Postorder:");
//		postOrder(root);
		int pre[] = {1,2,4,5,3,6,7};
		int in[] = {4,2,51,6,3,7};
		BinaryTreeNode<Integer>PreIn = getTreeFromPreorderAndInorder(pre,in);
		printLevelWise(PreIn);
		
	}


}
