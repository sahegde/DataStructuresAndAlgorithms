import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class train {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Map<Integer,String> map = new HashMap<Integer,String>();
    
	public static void readInputAndProcess(int n) throws Exception {		
		String []time = br.readLine().split(" ");
		int startTime = Integer.parseInt(time[0]);
		int endTime = Integer.parseInt(time[1]);
		
		for(int i = startTime; i < endTime; i++) {
			String s =""; 
			if(map.containsKey(i)) {
				s = map.get(i);
			}
			s += 1;
			map.put(i, s);
		}
		
	}
	
	public static int printMap() {
		int maxTracks = 0;
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
		    if(entry.getValue() != null && (Integer.parseInt(entry.getValue()) > maxTracks)) {
		    	maxTracks = Integer.parseInt(entry.getValue());
		    }
		}
		
		return maxTracks;
	}
	
	public static void main(String[] args)throws Exception {
		
        System.out.println("Enter the number of trains");
        int n = Integer.parseInt(br.readLine());
		                
        for(int i =0; i<n; i++) {
        	readInputAndProcess(n);
        }
        
        System.out.println("The number of tracks needed are "+printMap());
        
	}
}
