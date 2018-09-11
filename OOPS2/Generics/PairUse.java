package OOPS3.Generics;

public class PairUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pair<String> p = new Pair<String> ("ab","cd");
		p.setFirst("def");
		String s = p.getFirst();
		Pair<Integer> p1= new Pair<Integer> (1,2);
		Pair<Character> p2 = new Pair<Character>('c','a');
		Pair<Character> p3 = new Pair<>('c','a');
	}

}
