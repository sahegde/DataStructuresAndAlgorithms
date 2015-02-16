import java.util.LinkedList;
import java.util.Queue;
import org.apache.commons.collections.map.MultiValueMap;

public class Djistkra {

	static int size = 9;
	static int graph[][] = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
			{ 4, 0, 8, 0, 0, 0, 0, 11, 0 }, { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
			{ 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
			{ 0, 0, 4, 0, 10, 0, 2, 0, 0 }, { 0, 0, 0, 14, 0, 2, 0, 1, 6 },
			{ 8, 11, 0, 0, 0, 0, 1, 0, 7 }, { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
	
	static boolean []visited = new boolean[9];
	static int []distance = {0,999,999,999,999,999,999,999,999};
	static boolean alreadyDequed[] = new boolean[9];
	
	private static int findMinVertex() {
		int min = 10000000;
		int minIndex = 0;
		for(int i = 0; i<size;i++) {
			if(distance[i] != 0 && distance[i] < min && alreadyDequed[i] != true) {
				min  = distance[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	private static void process(Queue<Integer> q,int source) {
		while(!q.isEmpty()) {
			int item = q.poll();
			alreadyDequed[item] = true;
			for(int i = 0; i < size;i++) {
				if(graph[item][i] != 0) {
					if((distance[i] > (distance[item] + graph[item][i]))) {
						distance[i] = distance[item] + graph[item][i];
					}
				}
			}
			
			int min = findMinVertex();
			if(alreadyDequed[min] == true) {
				return;
			}
			q.add(min);
		}
	}

	private static void djistkra(int graph[][], int source) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(source);
		visited[source] = true;
		distance[source] = 0;
		process(q,source);
	}

	private static void printShortestDistances() {
		for (int i = 0; i < distance.length; i++) {
			System.out.println(i + " " +distance[i]);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Lets implement Djikstras algorithm");
		djistkra(graph, 0);
		
		printShortestDistances();
	}
}
