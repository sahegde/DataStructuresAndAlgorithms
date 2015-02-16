import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestClass {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int []output = new int[T];
		for (int i = 0; i < T; i++) {
			String[] str = (br.readLine()).split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			int N = Integer.parseInt(str[2]);

			output[i] = process(a, b, N);
		}
		
        for(int i = 0; i < T;i++) {
        	System.out.println(output[i]);
        }
	}

	private static int process(int a, int b, int N) {

		int lcm;
		int n = a, m = b, n1=n, m1=m;
		while (m1 != n1) {
		    if (m1 > n1)n1 += n;
		    else m1 += m;
		}
		lcm = m1;
		//System.out.println(lcm);
		int div_fac1 = lcm / a;
		int div_fac2 = lcm / b;
		int no = div_fac1 + div_fac2 - 1;

		int rem = N / no;
		int dec = N % no;
		int prodRem = rem * lcm;
		int prodRem1 = prodRem;
		while (dec > 0) {
			int x = prodRem + a;
			int y = prodRem1 + b;

			if (x > y) {
				dec--;
				prodRem1 = y;
			} else {
				dec--;
				prodRem = x;
			}
		}

		return prodRem1 > prodRem ? prodRem1:prodRem;
	}
}
