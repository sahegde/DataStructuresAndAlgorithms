import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class sample {
    public static void main(String args[] ) throws Exception {
    	
    	Map<String,Integer> m = new HashMap<String,Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
        	String str = br.readLine();
        	String []s = str.split(" ");
        	long []l = new long[3];
        	for(int j = 0; j< 3;j++) {
        		l[j] = Long.parseLong(s[j]);
        	}
        	Arrays.sort(l);
        	String a = l[0]+l[1]+l[2]+"";
        	if(m.containsKey(a)) {
        		int no = m.get(a);
        		m.put(a, no+1);
        	}else {
        		m.put(a, 1);
        	}
        }
        
		int count = 0;
		for(Iterator<String> it = m.keySet().iterator();it.hasNext();){
			if(m.get(it.next()) == 1) count++;
		}
		System.out.println(count);
    }
}
