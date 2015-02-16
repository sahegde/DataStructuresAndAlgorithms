import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFS {
	private Map<Integer,List<Integer>> adjMap;
	int[] visited;
	public BFS(int n) {
		adjMap = new HashMap<Integer,List<Integer>>();
		visited = new int[n];
	}
	
	public void addEdge(int a, int b) {
		List<Integer> l = new ArrayList<Integer>();
		if(adjMap.containsKey(a)) {
			l = adjMap.get(a);
		}
		l.add(b);
		adjMap.put(a, l);
	}
	
	public static void printMap(Map<Integer,List<Integer>> mp) {
		for (Map.Entry<Integer, List<Integer>> entry : mp.entrySet()) {
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
	}
	
	public void BfsTraversal(int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		visited[n] = 1;
		
		while(!q.isEmpty()) {
			System.out.print(q.peek()+" ");
			List<Integer> l = adjMap.get(q.poll());
			for(int a: l) {
				if(visited[a] != 1) {
					q.add(a);
					visited[a] = 1;
				}
			}
		}
	}
	
	public static void main(String[] args) {
	    BFS b = new BFS(4);
	    b.addEdge(0, 1);
	    b.addEdge(0, 2);
	    b.addEdge(1, 2);
	    b.addEdge(2, 0);
	    b.addEdge(2, 3);
	    b.addEdge(3, 3);
	 
	    System.out.println("Following is the tree: ");
	    printMap(b.adjMap);
	    
	    System.out.println("Following is Breadth First Traversal (starting from vertex 2)");
	    
	    b.BfsTraversal(2);
	}
}
