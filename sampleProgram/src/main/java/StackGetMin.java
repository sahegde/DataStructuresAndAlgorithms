
public class StackGetMin {
	private static Stack<Integer> s1 = new Stack<Integer>();
	private static Stack<Integer> s2 = new Stack<Integer>();
	
	private static void insertMinToS2(Stack<Integer> s,int n) {
		if(!s.isEmpty()) {
			int val = s.peek();
			if(val <= n) {
				s.push(val);
				return;
			}
		}
		s.push(n);
	}
	
	private static int getMin() {
		return s2.peek();
	}
	
	private static void deleteMinFromS2(Stack<Integer> s) {
		s.pop();
	}
	
	public static void main(String[] args) {
		
		s1.push(1);
		insertMinToS2(s2,1);
		
		s1.push(2);
		insertMinToS2(s2,4);
		
		s1.push(4);
		insertMinToS2(s2,3);
		
		s1.push(3);
		insertMinToS2(s2,2);
		
		System.out.println("Min: "+getMin());
		
		s1.pop();
		deleteMinFromS2(s2);
		
		System.out.println("Min: "+getMin());
		
	}
}
