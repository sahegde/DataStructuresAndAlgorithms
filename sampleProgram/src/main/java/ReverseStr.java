public class ReverseStr {
	private static String reverse(String str) {
		Stack<Character> s = new Stack<Character>();
		for (int j = 0; j < str.length(); j++) {
			s.push(str.charAt(j));
		}
		String revStr = new String();
		while (!s.isEmpty()) {
			revStr = revStr + s.pop();
		}
		return revStr;
	}

	private static String swap(String str,int i) {
		String s = new String();
		int n = str.length();
		s = str.charAt(n-i) + str.substring(i,n-i)+str.charAt(i-1);
		return s;
	}
	
	private static String iterativeReverse(String str) {
		for (int i = 0; i < str.length()/2; i++) {
			str = swap(str,i+1);
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		String str = "sandeep";
		str = iterativeReverse(str);
		System.out.println("Reveresd String is: " + str);
	}
}
