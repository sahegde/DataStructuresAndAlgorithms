package linkedListPorgrams;

import java.util.Iterator;

class Node<T> {
	T value;
	Node<T> next;
}

public class LinkedList {

	private static Node<Integer> addNodeAtFirst(Node<Integer> head1, int value) {
		Node<Integer> node = new Node<Integer>();
		node.value = value;
		node.next = head1;

		return node;
	}

	private static Node<Integer> reverse(Node<Integer> head1) {
		Node<Integer> ret = null;
		if (head1 == null) {
			return null;
		}
		if (head1.next.next != null) {
			ret = reverse(head1.next);
		} else {
			ret = head1.next;
		}
		Node<Integer> cur = head1;
		Node<Integer> temp = cur.next;
		temp.next = cur;
		cur.next = null;

		return ret;
	}
	
	private static Node<Integer> reverseRec(Node<Integer> head) {
		
		Node<Integer> ret = null;
		if(head == null) {
			return null;
		}
		
		if(head.next.next != null) {
			ret = reverseRec(head.next);
		}else {
			ret = head.next;
		}
		
		head.next.next = head;
		head.next = null;
		return ret;
	}

	private static Node<Integer> pairWiseReverse(Node<Integer> head1) {
		Node<Integer> next = head1.next;
		Node<Integer> cur = null,sample = null;
		Node<Integer> ret = head1.next;
		while(head1 != null && next != null) {
			cur = next.next;
			next.next = head1;
			head1.next = cur;
			sample = head1;
			if(cur != null) 
				next = cur.next;
			else 
				next = null;
			head1 = cur;
			if(next != null)
				sample.next = next;
			else 
				sample.next = cur;
		}
		
		return ret;
	}

	private static void display(Node<Integer> head1) {
		while (head1 != null) {
			System.out.print(head1.value);
			head1 = head1.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node<Integer> head1 = null;
		head1 = addNodeAtFirst(head1, 9);
		head1 = addNodeAtFirst(head1, 8);
		head1 = addNodeAtFirst(head1, 9);
		head1 = addNodeAtFirst(head1, 9);
		head1 = addNodeAtFirst(head1, 8);
		//display(head1);

		Node<Integer> head2 = null;
		head2 = addNodeAtFirst(head2, 9);
		head2 = addNodeAtFirst(head2, 9);
		head2 = addNodeAtFirst(head2, 9);
		head2 = addNodeAtFirst(head2, 9);
		head2 = addNodeAtFirst(head2, 9);
		//display(head2);
		
		Node<Integer> tail1 = reverse(head1);
		display(tail1);
		Node<Integer> tail3 = reverseRec(head2);
		display(tail3);
		//Node<Integer> tail2 = reverse(head2);
		
	/*	Node<Integer> head3 = null;
		
		int carry = 0;
		int value = 0;
		while(tail1 != null && tail2 != null) {
			value = (tail1.value + tail2.value + carry)% 10;
			carry = (tail1.value + tail2.value + carry)/ 10;
			head3 = addNodeAtFirst(head3, value);
			tail1 = tail1.next;
			tail2 = tail2.next;
		}
		
		while(tail1 != null) {
			value = (tail1.value + carry)% 10;
			carry = (tail1.value + carry) / 10;
			head3 = addNodeAtFirst(head3, value);
			tail1 = tail1.next;
		}
		while(tail2 != null) {
			value = (tail2.value + carry)% 10;
			carry = (tail2.value + carry) / 10;
			head3 = addNodeAtFirst(head3, value);
			tail2 = tail2.next;
		}
		head3 = addNodeAtFirst(head3, carry);
		display(head3);
		
		head1 = reverse(head1);

		display(head1);
		
		head1 = pairWiseReverse(head1);
		
		display(head1);*/
	}
}
