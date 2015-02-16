import java.util.Scanner;

public class InsertionSort {

	private void sort(int[] a) {
		int shifts = 0;
		for (int j = 1; j < a.length; j++) {
			int i = j - 1;
			int value = a[j];
			while (i >= 0 && value < a[i]) {
				shifts++;
				a[i + 1] = a[i];
				i--;
			}
			a[i + 1] = value;
		}
		
		System.out.println(shifts);

	}

	public static void main(String[] args) {
		InsertionSort is = new InsertionSort();
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		String str = scanner.nextLine();
		
		String []b = str.split(" ");
		int []a = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(b[i]);
		}
		
		is.sort(a);
	}
}


