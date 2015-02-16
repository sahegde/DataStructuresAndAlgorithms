import java.util.NoSuchElementException;

public class Subset {	
	public static void main(String[] args) {
		int k = Integer.parseInt(args[0]);

		RandomizedQueue<Object> r = new RandomizedQueue<Object>();

		String str = StdIn.readLine();
		String[] words = str.split(" ");

		for (String string : words) {
			r.enqueue(string);
		}

		while (k > 0) {
			System.out.println(r.dequeue());
			k--;
		}
	}

}
