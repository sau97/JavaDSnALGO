package Stacks;

public class BBuse {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BracketBalance<String> bb= new BracketBalance<>("[a+(b+c)]");
		System.out.println(bb.checkBalanced());
		
		double num[] = {5, 5, 5, 5, 5, 6};
        double result;
        result = 0;
        for (int i = 0; i < 6; ++i) 
            result = result + num[i];
    System.out.print(result/6);
	}

}
