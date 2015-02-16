import java.lang.UnsupportedOperationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

class Node<Item> {
	Item item;
	Node<Item> right;
	Node<Item> left;
}

public class Deque<Item> implements Iterable<Item> {
	private int n;
	private Node<Item> first, last;

	public Deque() {
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		if (first == null && last == null) {
			return true;
		} else {
			return false;
		}
	}

	public int size() {
		return n;
	}

	public void addFirst(Item item) {
		if (item == null) {
			throw new NullPointerException();
		}
		n++;
		Node<Item> firstNode = new Node<Item>();
		firstNode.item = item;
		firstNode.left = null;
		firstNode.right = null;
		if (first == null && last == null) {
			first = firstNode;
			last = firstNode;
			return;
		}
		first.left = firstNode;
		firstNode.right = first;
		first = firstNode;
	}

	public void addLast(Item item) {
		if (item == null) {
			throw new NullPointerException();
		}
		n++;
		Node<Item> lastNode = new Node<Item>();
		lastNode.item = item;
		lastNode.left = null;
		lastNode.right = null;
		if (first == null && last == null) {
			first = lastNode;
			last = lastNode;
			return;
		}

		last.right = lastNode;
		lastNode.left = last;
		last = lastNode;

	}

	public Item removeFirst() {
		Node<Item> temp;
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else if (first == last) {
			n--;
			Item item = first.item;
			first = null;
			last = null;
			return item;
		} else {
			n--;
			temp = first;
			first = first.right;
			first.left = null;
			return temp.item;
		}
	}

	public Item removeLast() {
		Node<Item> temp;
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else if (first == last) {
			n--;
			Item item = last.item;
			first = null;
			last = null;
			return item;
		} else {
			n--;
			temp = last;
			last = last.left;
			last.right = null;
			return temp.item;
		}
	}

	public Iterator<Item> iterator() {
		return new DequeIterator();
	}

	private void printDeque() {
		Iterator<Item> i = iterator();
		System.out.println("Priting... ");
		while (i.hasNext()) {
			System.out.print(i.next() + " ");
		}
	}

	public static void main(String[] args) {
		Deque<Object> d = new Deque<Object>();
		d.addFirst(1);
		d.addFirst("sandeep");
		d.addLast("pradeep");
		System.out.println(d.size());
		d.printDeque();
		System.out.println("\nremoving first item");
		d.removeFirst();
		d.printDeque();
		System.out.println("\nremoving last item");
		d.removeLast();
		d.printDeque();
		//d.removeFirst();
		//d.printDeque();
		d.removeLast();
		d.printDeque();
		//d.removeFirst();
		System.out.println("\nadding");
		d.addLast("sumana");
		d.printDeque();
		System.out.println(d.size());
		d.removeFirst();
		d.printDeque();
	}

	private class DequeIterator implements Iterator<Item> {

		private Node<Item> current = first;

		@Override
		public boolean hasNext() {
			return (current != null);
		}

		@Override
		public Item next() {
			if(current == null) {
				throw new NoSuchElementException();
			}
			Item item = current.item;
			current = current.right;
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}
}