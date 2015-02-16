import java.util.Stack;

class queue<T> {
	Stack<T> s1 = new Stack<T>();
	Stack<T> s2 = new Stack<T>();
	void insert(T a) {
		while(!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		s1.push(a);
		
		while(!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}
	
	T delete() {
		if(!s1.isEmpty()) {
			return s1.pop();
		}
		return null;
	}
	
	void display() {
		for(T a : s1) {
			System.out.print(a+" ");
		}
		System.out.println();
	}
}

public class queueUsingTwoStacks{
	public static void main(String[] args) {
		queue<Integer> q = new queue<Integer>();
		q.insert(1);
		q.insert(2);
		q.insert(3);
		q.display();
		
		q.delete();
		
		q.display();
	}
}
