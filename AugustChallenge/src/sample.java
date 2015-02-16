import java.io.BufferedReader;
import java.io.InputStreamReader;


public class sample {
	//TestClass
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	public static int processPower() throws Exception{
		
		String input[] = br.readLine().split(" "); 
		
		int F = Integer.parseInt(input[0]);
		int G = Integer.parseInt(input[1]);
		int S = Integer.parseInt(input[2]);
		int P = Integer.parseInt(input[3]);
		int C = Integer.parseInt(input[4]);
		int power = Integer.parseInt(input[5]);
		
		double precedenceSamurai = S/100;
		double precendencePaladin = P/175;
		double precedenceChampion = C/150;
		
		int powerF = 0;
		
		if(precedenceSamurai >= precendencePaladin && precedenceSamurai >= precedenceChampion) {
			if(precendencePaladin > precedenceChampion) {
				while((F - 100) > 0) {
					F = F - 100;
					powerF += S;
				}
				
				while((F -125) > 0 && (G - 50) > 0) {
					F = F - 125;
					G = G - 50;
					powerF += P;
				}
				
				while((F -50) > 0 && (G - 100) > 0) {
					F = F - 50;
					G = G - 100;
					powerF += C;
				}
				
			}else {
				while((F - 100) > 0) {
					F = F - 100;
					powerF += S;
				}
				
				while((F -50) > 0 && (G - 100) > 0) {
					F = F - 50;
					G = G - 100;
					powerF += C;
				}
				
				while((F -125) > 0 && (G - 50) > 0) {
					F = F - 125;
					G = G - 50;
					powerF += P;
				}
			}
		}else if(precendencePaladin >= precedenceSamurai && precendencePaladin >= precedenceChampion ) {
			if(precedenceSamurai > precedenceChampion ) {
				while((F -125) > 0 && (G - 50) > 0) {
					F = F - 125;
					G = G - 50;
					powerF += P;
				}
				
				while((F - 100) > 0) {
					F = F - 100;
					powerF += S;
				}
				
				while((F -50) > 0 && (G - 100) > 0) {
					F = F - 50;
					G = G - 100;
					powerF += C;
				}
				
			}else {
				while((F -125) > 0 && (G - 50) > 0) {
					F = F - 125;
					G = G - 50;
					powerF += P;
				}
				
				while((F -50) > 0 && (G - 100) > 0) {
					F = F - 50;
					G = G - 100;
					powerF += C;
				}
				while((F - 100) > 0) {
					F = F - 100;
					powerF += S;
				}
			}
			
		}else if(precedenceChampion >= precedenceSamurai && precedenceChampion >= precendencePaladin) {
			if(precedenceSamurai > precendencePaladin) {
				while((F -50) > 0 && (G - 100) > 0) {
					F = F - 50;
					G = G - 100;
					powerF += C;
				}
				while((F - 100) > 0) {
					F = F - 100;
					powerF += S;
				}
				while((F -125) > 0 && (G - 50) > 0) {
					F = F - 125;
					G = G - 50;
					powerF += P;
				}
			}else {
				while((F -50) > 0 && (G - 100) > 0) {
					F = F - 50;
					G = G - 100;
					powerF += C;
				}
				while((F -125) > 0 && (G - 50) > 0) {
					F = F - 125;
					G = G - 50;
					powerF += P;
				}
				while((F - 100) > 0) {
					F = F - 100;
					powerF += S;
				}
			}
		}
		
		return(powerF-power);
		
	}
	
    public static void main(String args[] ) throws Exception {

        int T = Integer.parseInt(br.readLine());
        int []output = new int[T];
        for (int i = 0; i < T; i++) {
            output[i] = processPower();
        }
        
        for (int i = 0; i < T; i++) {
            System.out.println(output[i]);
        }
    }
}
