import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TestClass {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        String main= "";
        List<String> l= new ArrayList<String>();
        for(int i = 0; i< n; i++) {
        	String []str = br.readLine().split(" ");
        	int index = Integer.parseInt(str[1]);
        	String temp = str[2];
        	String build = "";
        	if(str[0].equals("+")) {
        		if(index == 0) {
        			main = str[2];
        		}
        		else {
	        		for(int j = 0; j < main.length();j++) {
	        			if(index == j) {
	        				build += temp;
	        			}
	        			build += main.charAt(j);
	        		}
	        		main = build;
        		}
        	}
        	else if(str[0].equals("?")) {
        		int length = Integer.parseInt(str[2]);
        		l.add(main.substring(index-1, index+length-1));
        	}	
        }
        
        for(int i = 0; i < l.size(); i++) {
        	System.out.println(l.get(i));
        }
        
    }
}