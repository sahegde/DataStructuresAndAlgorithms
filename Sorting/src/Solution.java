import java.util.Scanner;

public class Solution {
	
	int []result;

	public void setResult(int n) {
		this.result = new int[n];
	}

	int count = 0;
	
	
	
	private void findMaxVehicle(String input,int []width) {
		String []temp = input.split(" ");
		int entry = Integer.parseInt(temp[0]);
		int exit = Integer.parseInt(temp[1]);
		
		int leastVehicleSize = 3;
		
		for(int i = entry; i <= exit; i++) {
			if(width[i] < leastVehicleSize) {
				leastVehicleSize = width[i];
			}
		}
		
		result[count++] =  leastVehicleSize;
		
	}
	
	private void print() {
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
	
	public static void main(String[] args) {
		
		Solution s = new Solution();
		
		Scanner scanner = new Scanner(System.in);
		String []inputs = scanner.nextLine().split(" ");
		int N = Integer.parseInt(inputs[0]);
		int T = Integer.parseInt(inputs[1]);
		
		s.setResult(T);
		
		
		String []widthInput = scanner.nextLine().split(" ");
		int []width = new int[N];
		
		for (int i = 0; i < N; i++) {
			width[i] = Integer.parseInt(widthInput[i]);
		}
		
		for(int i = 0; i < T; i++) {
			s.findMaxVehicle(scanner.nextLine(),width);
		}
		
		s.print();
		
		scanner.close();
	}
}
