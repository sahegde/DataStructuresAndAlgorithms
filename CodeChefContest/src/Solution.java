import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


class Node {
	int value;
	Node next;
}

public class Solution {
	static boolean flag = false;
	static Node head = new 	Node();
	private static void process(Node cur) {
		if(cur == null) {
			return;
		}
		process(cur.next);
		if(head != cur && !flag) {
			head.value = head.value - cur.value;
			System.out.println(head.value);
		}else {
			System.out.println(head.value);
			flag = true;
		}
		
		head = head.next;

	}

	public static void main(String[] args) throws IOException {
		Node n = new Node();
		n.value = 5;
		n.next = null;
		head= n;
		for(int i =4 ;i > 0;i--) {
			n = head;
			while(n.next != null) {
				n = n.next;
			}
			Node newNode = new Node();
			newNode.value = i;
			newNode.next = null;
			n.next = newNode;
			
		}
		
		process(head);
	}
}
