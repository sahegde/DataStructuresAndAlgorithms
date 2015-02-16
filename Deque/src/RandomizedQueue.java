import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private Item[] a;
	private int n;

	public RandomizedQueue() {
		a = (Item[]) new Object[1];
	}

	private void resizeArray(int capacity) {
		Item[] temp = (Item[]) new Object[capacity];
		for (int i = 0; i < n; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}

	public boolean isEmpty() {
		return (n == 0);
	}

	public int size() {
		return n;
	}

	public void enqueue(Item item) {
		if (item == null) {
			throw new NullPointerException();
		}
		if (a.length == n)
			resizeArray(a.length * 2);
		a[n++] = item;
	}

	public Item dequeue() {
		if (n == 0) {
			throw new NoSuchElementException();
		}
		if (n > 0 && n == a.length / 4) {
			resizeArray(a.length / 2);
		}
		StdRandom.shuffle(a,0,n-1);
		Item i = a[--n];
		a[n] = null;
		return i;

	}

	private void printQueue() {
		Iterator<Item> i1 = iterator();
		System.out.println("\nSunn");
		while(i1.hasNext()) {
			System.out.print(i1.next()+" ");
		}
		
		Iterator<Item> i2 = iterator();
		System.out.println("\nMunn");
		while(i2.hasNext()) {
			System.out.print(i2.next()+" ");
		}
	}
	
	public Item sample() {
		if (n == 0) {
			throw new NoSuchElementException();
		}
		if (n > 0 && n == a.length / 4) {
			resizeArray(a.length / 2);
		}
		StdRandom.shuffle(a,0,n-1);
		Item i = a[n - 1];
		return i;
	}

	public Iterator<Item> iterator() {
		return new RandomIterator<>();
	}
	
	public static void main(String[] args) {
		RandomizedQueue<Object> r = new RandomizedQueue<Object>();
		r.enqueue("1");
		r.enqueue("sandeep");
		r.enqueue("pradeep");
		r.printQueue();
		System.out.println("\n"+r.dequeue());
		r.printQueue();
		r.enqueue("1");
		r.enqueue("sandeep");
		r.enqueue("pradeep");
		r.printQueue();
		System.out.println("\n"+r.dequeue());
		r.printQueue();
	}

	private class RandomIterator<Item> implements Iterator<Item> {
		private Item[] current;
		private int count;
		RandomIterator() {
			current = (Item[])a;
			if(current != null) {
				StdRandom.shuffle(current,0,n-1);
			}
		}
		
		@Override
		public boolean hasNext() {
			return (count < n);
		}

		@Override
		public Item next() {
			if(current[count] == null) {
				throw new NoSuchElementException();
			}
			return current[count++];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}