package Stacks;

public class StackUseClass {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//StackArray stack = new StackArray();
		StackUsingLL <Integer> stack  = new StackUsingLL<>();
		for(int i = 1;i<=11 ; i++) {
			stack.push(i);
		}
		while(!stack.isEmpty()) {
				System.out.println(stack.pop());
		}
	}

}
