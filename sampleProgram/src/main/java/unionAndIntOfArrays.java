/*import java.io.BufferedReader;
import java.io.InputStreamReader;*/

public class unionAndIntOfArrays {
	
	private static void findUnion(int []arr1, int arr2[]) {
		int l = 0,k = 0;
		while(l < arr1.length && k < arr2.length) {
			if(arr1[l] > arr2[k]) {
				System.out.println(arr2[k]);
				k++;
			}else if(arr1[l] < arr2[k]){
				System.out.println(arr1[l]);
				l++;
			}else {
				System.out.println(arr1[l]);
				l++;k++;
			}
		}
		
		while(l < arr1.length) {
			System.out.println(arr1[l++]);
		}
		
		while(k < arr2.length) {
			System.out.println(arr2[k++]);
		}
	}
	
	private static void findIntersection(int []arr1, int arr2[]) {
		int l = 0,k = 0;
		while(l < arr1.length && k < arr2.length) {
			if(arr1[l] > arr2[k]) {
				k++;
			}else if(arr1[l] < arr2[k]){
				l++;
			}else {
				System.out.println(arr1[l]);
				l++;k++;
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		int arr1[] = {1, 2,3, 4, 5, 7};
		int arr2[] = {2, 3, 5, 6};
		
/*        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);*/
		
		System.out.println("Lets find the union of these 2 arrays");
		findUnion(arr1,arr2);
		System.out.println("Lets find the intersection of these 2 arrays");
		findIntersection(arr1,arr2);
	}
}
