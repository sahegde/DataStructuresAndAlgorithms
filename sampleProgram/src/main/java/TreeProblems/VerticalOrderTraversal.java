package TreeProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VerticalOrderTraversal {
	
	private static Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
	
	private static void populateHashMap(TreeNode<Integer> root, int n) {
		if(root != null) {			
			List<Integer> l = null;
			if(map.get(n) == null) {
				l = new ArrayList<Integer>();
			}else {
				l = map.get(n);
			}
			l.add(root.getValue());
			map.put(n, l);
			
			populateHashMap(root.getLeft(), n-1);
			populateHashMap(root.getRight(), n+1);
		}
	}
	
	private static void printVerticalOrderTraversal() {
		for(Integer key : map.keySet()) {
			System.out.println("Key :"+key+" Value: "+map.get(key));
		}
	}
	
	public static void main(String[] args) {
		TreeNode<Integer> root = LevelOrderTraversal.buildTree();
		populateHashMap(root,0);
		
		printVerticalOrderTraversal();
	}
}
