import java.util.HashMap;

public class FindFirstRepeatingElement {
	public static void main(String[] args) {
		int arr[] = { 10, 5, 3, 4, 3, 5, 6,5,10};
		HashMap<Integer, Integer> h = new HashMap<Integer,Integer>();
		int smallest = Integer.MAX_VALUE;
		
		for(int i = 0;i<arr.length;i++) {
			if(h.containsKey(arr[i])) {
				if(h.get(arr[i]) < smallest)
					smallest = h.get(arr[i]);
			}else {
				h.put(arr[i],i);
			}
		}
		System.out.println("This is the first repeating elememt: "+arr[smallest]);
	}
}
