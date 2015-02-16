import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class TestClass {
    public static void main(String args[] ) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        
        int []strength = new int[N];
        int []calories = new int[N];
        
        String []stren = br.readLine().split(" ");
        String []cal = br.readLine().split(" ");
        
        for (int i = 0; i < N; i++) {
            strength[i] = Integer.parseInt(stren[i]);
            calories[i] = Integer.parseInt(cal[i]);
        }
        
        Arrays.sort(strength);
        Arrays.sort(calories);
        
        int sum = 0;
        
        for (int i = 0; i < N; i++) {
			sum += strength[i] * calories[i];
		}
        
        System.out.println(sum);
        

        
    }
}