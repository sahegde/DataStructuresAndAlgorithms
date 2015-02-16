import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
	
	private static int findNearestOddNumber(int x) {
		int a = Math.abs(x);
		
		if(a == 0) {
			return 1;
		}
		else if (a % 2 == 1)
			return a;
		else {
			return a-1;
		}
 
	}
	
	private static int findNearestEvenNumber(int x) {
		int a = Math.abs(x);
		
		if(a == 0) {
			return 0;
		}
		else if (a % 2 == 1)
			return a -1;
		else {
			return a -2;
		}
 
	}
		
	private static boolean process(int x, int y) throws IOException {
		int a = 0;
		int b = 0;
		
		if(x == 0 && y == 0) {
			return true;
		}
		int loopFactor = 1;
		int nearestOddNo = findNearestOddNumber(x);
		int nearestEvenNo = findNearestEvenNumber(y);
		
		if(nearestOddNo > nearestEvenNo+1) {
			a = nearestOddNo;
			b = (nearestOddNo -1) * -1;
		}else {
			b = nearestEvenNo* -1;
			a = nearestEvenNo + 1;
		}
 
		loopFactor = a * 2;
		//System.out.println("sande "+a+" "+b);
		if(a == x && b == y) {
			return true;
		}
		//System.out.println("sandeep "+a+" "+b);
		int[][] arr = {{ 0, 1 }, { -1, 0 }, { 0, -1 },{ 1, 0 }};
		 
		int counter = 0;
		int r = Math.abs(x);
		int s = Math.abs(y);
		while(Math.abs(a) <= r  || Math.abs(b) <= s) {
 
			int k = counter++ % 4;
			
			for (int i = 0; i < loopFactor ; i++) {
				
				//System.out.println("sande "+a+" "+b);
				
				a = a + arr[k][0];
				b = b + arr[k][1];
								
				if(a == x && b == y) {
					return true;
				}
			}
			loopFactor++;
		}
 
		return false;
	}
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		boolean[] output = new boolean[T];
		for (int i = 0; i < T; i++) {
			String[] inputs = (br.readLine()).split(" ");
			int x = Integer.parseInt(inputs[0]);
			int y = Integer.parseInt(inputs[1]);
 
			output[i] = process(x, y);
		}
 
		for (int i = 0; i < T; i++) {
			System.out.println(output[i] ? "YES" : "NO");
		}
	}
} 