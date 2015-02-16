import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReverseLinkedList {
	
	private static List<Integer> reverse(List<Integer> l) {
		Iterator<Integer> i = l.iterator();
		List<Integer> l2 = new ArrayList<Integer>();
		Stack<Integer> s = new Stack<Integer>();
		while(i.hasNext()) {
			s.push(i.next());
		}
		while(!s.isEmpty()) {
			l2.add(s.pop());
		}
		return l2;
	}
	
	private static void printList(List<Integer> l) {
		System.out.println("The contets of the list are:");
		for(int a: l) {
			System.out.print(a+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		
		printList(l);
		
		l = reverse(l);
		
		printList(l);
	}
}
