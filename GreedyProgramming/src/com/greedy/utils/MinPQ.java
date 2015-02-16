package com.greedy.utils;

public class MinPQ<Key extends Comparable<Key>> {
	public Key pq[];
	public Key[] getPq() {
		return pq;
	}

	public void setPq(Key[] pq) {
		this.pq = pq;
	}

	int count;

	public MinPQ(int capacity) {
		pq = (Key[]) new Key[capacity +1];
		count = 1;
	}

	public void swim(int i) {
		int j = i / 2;
		while(i > 0 && j > 0 && less(pq[j],pq[i])) {
			exch(pq[i], pq[j]);
			i = i/2;
			j = i/2;
		}
	}

	public void sink(int i) {
		int left = 2*i;
		int right = 2*i + 1;
		while(left < count -1 && right < count -1) {
			boolean exRight = less(pq[left],pq[right]);
			if(exRight) {
				exch(pq[right], pq[i]);
				i = right;
			}
			else {
				exch(pq[left],pq[i]);
				i = left;
			}
			left = 2*i;
			right = 2*i + 1;
		}
		
	}

	public void insert(Key key) {
		pq[count] = key;
		swim(count);
		count++;
	}

	public Key deleteMin() {
		Key del = pq[1];
		exch(pq[count-1], del);
		pq[count-1] = null;
		sink(1);
		count--;
		return del;
	}

	public boolean less(Key a, Key b) {
		return ((a.compareTo(b)) < 0);
	}
	
	public void exch(Key a, Key b) {

		Key temp =  new Key(0);
		temp.value= a.value;
		a.value = b.value;
		b.value = temp.value;
				
	}
	
	public void printPQ() {
		for(int i = 1; i < count; i++) {
			System.out.print(" "+pq[i].value);
		}
		System.out.println();
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	public static void main(String[] args) {
		//Inserting
		MinPQ<Key> queue = new MinPQ<Key>(10);
		queue.insert(new Key(2));
		queue.insert(new Key(1));
		queue.insert(new Key(3));
		queue.insert(new Key(4));
		queue.insert(new Key(8));
		queue.insert(new Key(7));
		queue.insert(new Key(9));
		
		queue.printPQ();
		
		//Deleting
		queue.deleteMin();
		queue.deleteMin();
		queue.deleteMin();
		
		queue.printPQ();

	}
	
	public static class Key implements Comparable<Key> {
		public int value;
		public int index;

		public Key(int value) {
			this.value = value;
		}

		public Key(int value, int index) {
			this.value = value;
			this.index = index;
		}
		
		public int compareTo(Key key) {
			if (this.value > key.value) {
				return -1;
			} else if (this.value < key.value) {
				return 1;
			} else {
				return 0;
			}
		}
	}
}
