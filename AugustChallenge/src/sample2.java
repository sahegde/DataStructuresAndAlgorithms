import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class sample2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Stack<int [][]> s = new Stack<int [][]>();
	
	private static boolean isValidIndex(int i, int j,int N) {
		return (i >= 0 && i < N && j >= 0 && j < N);
	}
	
	private static int process(int [][]arr,int N) {
		s.push(arr);
		int i =0,j = 0;
		if(arr[0][0] == 1 || arr[N-1][N-1] == 1) {
			return 0;
		}
		int noOfRoutes = 0;
		while(!s.isEmpty()) {
			arr = s.pop();
			int [][] sample = arr.clone();
			
			boolean flag = false;
			for (int k = 0; k < sample.length && flag == false; k++) {
				for (int l = 0; l < sample.length; l++) {
					if(sample[k][l] == 2) {
						flag = true;
						i = k;
						j = l;
						break;
					}
				}
			}
			
			int dataArray[][] = { { 0, -1 }, { -1, 0 }, { 1, 0 }, { 0, 1 } };
			for (int r = 0; r < 4; r++) {
				int m = i + dataArray[r][0];
				int n = j + dataArray[r][1];
				if (isValidIndex(m, n, N) && sample[m][n] == 0) {
					int [][] sample2 = new int[N][N];
				    for(int x = 0; x< N; x++){
				        for (int y = 0; y < N; y++){
				            sample2[x][y] = sample[x][y];
				        }
				    }

					sample2[i][j] = 1;
					sample2[m][n] = 2;
					
					if(m == N-1 && n  == N-1) {
						noOfRoutes++;
					}else {
						s.push(sample2);
					}
				}
			}
		}
		return noOfRoutes;
	}
	
	private static int inputArrayAndProcess(int N) throws Exception {
		int [][]arr = new int[N][N];
		for(int i = 0; i< N; i++) {
			String str = br.readLine();
			String []s = str.split(" ");
			for(int j =0; j< N;j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
		return process(arr,N);
	}
	
    public static void main(String args[] ) throws Exception {
        String line = br.readLine();
        int T = Integer.parseInt(line);
        int []output = new int[T];
        for (int i = 0; i < T; i++) {
        	int N = Integer.parseInt(br.readLine());
        	output[i] = inputArrayAndProcess(N);
        }
        for(int i = 0; i < T;i++) {
        	System.out.println(output[i]);
        }
    }
}
