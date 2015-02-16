import java.util.ArrayList;
import java.util.List;

class Stack<T> {
	List<T> l = new ArrayList<T>();
	void push(T a) {
		l.add(a);
	}

	T pop() {
		if(!l.isEmpty()) {
			return l.remove(l.size() -1);
		}
		return null;
	}

	void display() {
		for(T a: l) {
			System.out.print(a+" ");
		}
		System.out.println();
	}
	
	boolean isEmpty() {
		return l.size() == 0 ? true:false;
	}
	
	T peek() {
		return l.get(l.size() -1);
	}
	
}

public class stackUsingLinkedList {
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		
		s.display();
		
		s.pop();
		
		s.display();
		
		s.pop();
		
		s.display();
		
	}
}
