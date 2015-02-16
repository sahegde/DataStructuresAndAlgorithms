package com.greedy.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.greedy.utils.MinPQ;
import com.greedy.utils.MinPQ.Key;

public class Dijkstras {
	private static int intMax = Integer.MAX_VALUE;
	
	private static Map<Integer, List<Integer>> populateAdjacencyList(int costMatrix[][]) {
		Map<Integer,List<Integer>> adjacencyList = new HashMap<Integer,List<Integer>>();
		List<Integer> l;
		for(int i = 0;i < costMatrix.length;i++) {
			for (int j = 0; j < costMatrix.length; j++) {
				if(costMatrix[i][j] != 0) {
					if(adjacencyList.get(i) == null) {
						l = new ArrayList<Integer>();
						l.add(j);
					}else {
						l = adjacencyList.get(i);
						l.add(j);
					}
					adjacencyList.put(i, l);
				}
			}
		}
		return adjacencyList;
	}
	
	private static void buildCostMatrix(int costMatrix[][]) {
		
		costMatrix[0][1] = 15;
		costMatrix[0][2] = 10;
		costMatrix[0][4] = 45;
		
		costMatrix[1][2] = 15;
		costMatrix[1][4] = 20;
		
		costMatrix[2][0] = 20;
		costMatrix[2][3] = 20;
		
		costMatrix[3][1] = 10;
		costMatrix[3][4] = 35;
		
		costMatrix[4][3] = 30;
		
		costMatrix[5][3] = 4;
		
		for (int i = 0; i < costMatrix.length; i++) {
			for (int j = 0; j < costMatrix.length; j++) {
				if(i != j && costMatrix[i][j] == 0) {
					costMatrix[i][j] = intMax;
				}
			}
		}
	}
	
	private static int[] performDijkstras(int sourceIndex, int costMatrix[][],Map<Integer,List<Integer>> adjacencyList) {
		MinPQ<Key> q = new MinPQ<Key>(100);
		int []valueNode = new int[costMatrix.length];
		for(int i = 0; i < valueNode.length; i++) {
			valueNode[i] = intMax;
		}
		
		Key source = new Key(0,sourceIndex);
		
		while(!q.isEmpty()) {
			List<Integer> l = adjacencyList.get(source.index);
			for(int i = 0;i < l.size();i++) {
				int a = costMatrix[source.index][l.get(i)];
				valueNode[l.get(i)] = valueNode[l.get(i)] < (a+valueNode[source.index]) ? valueNode[l.get(i)] : (a+valueNode[source.index]); 
				q.insert(new Key(valueNode[l.get(i)],l.get(i)));
			}
			
			source = q.deleteMin();
		}	
		
		return valueNode;
	}
	
	public static void main(String[] args) {
		int n = 6;
		int costMatrix[][] = new int[6][6];
		
		int source = 5;
		
		buildCostMatrix(costMatrix);
		Map<Integer,List<Integer>> adjacencyList = populateAdjacencyList(costMatrix);
		
		int []valueNode = performDijkstras(source,costMatrix,adjacencyList);
		
		for(int i=0; i < valueNode.length; i++) {
			System.out.println(valueNode[i]);
		}
	}
}
