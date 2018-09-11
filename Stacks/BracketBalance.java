package Stacks;
import java.util.Scanner;
public class BracketBalance <T>{
	private String str;
	StackUsingLL<Character> stack = new StackUsingLL<>();
	BracketBalance(String s){
		str = s;
		for(int i=0;i<s.length();i++) {
			if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i)=='[')
			stack.push(str.charAt(i));
		}
	
	}
	public  boolean checkBalanced() throws Exception{
		while(stack.size()!=0) {
			for(int i =0;i<str.length();i++) {
				if(str.charAt(i)== ')' || str.charAt(i) == '}'||str.charAt(i)==']') {
					char a = str.charAt(i);
					char pair = getpair(a);
					if(stack.top()!= pair)
						return false;
					else {
						stack.pop();
					}
			}
		}
	}
			return true;
}
	public char getpair(char s) {
		if(s == '(')
			return ')';
		if(s=='{')
			return '}';
		return '[';
	}

}
