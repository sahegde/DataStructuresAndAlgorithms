package TreeProblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversal {
	private static TreeNode<Integer> buildNode(int value) {
		TreeNode<Integer> node = new TreeNode<Integer>();
		node.setValue(value);
		node.setLeft(null);
		node.setRight(null);
		
		return node;
	}
	
	public static TreeNode<Integer> buildTree() {
		TreeNode<Integer> root = buildNode(1);	
		TreeNode<Integer> node2 = buildNode(2);
		TreeNode<Integer> node3 = buildNode(3);
		TreeNode<Integer> node4 = buildNode(4);
		TreeNode<Integer> node5 = buildNode(5);
		TreeNode<Integer> node6 = buildNode(6);
		TreeNode<Integer> node7 = buildNode(7);
		
		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(node6);
		node3.setRight(node7);
		
		return root;
	}
	
	public static void LevelOrderTraversalTree(TreeNode<Integer> root) {
		Queue<TreeNode<Integer>> q = new LinkedList<TreeNode<Integer>>();
		q.add(root);
		
		while(!q.isEmpty()) {
			TreeNode<Integer> node = new TreeNode<Integer>();
			node = q.peek().getLeft();
			if(node != null) {
				q.add(q.peek().getLeft());
				
			}
			node = q.peek().getRight();
			if(node != null) 
				q.add(q.peek().getRight());
			
			System.out.print(q.remove().getValue()+" ");
		}
	}
	
	public static TreeNode<Integer> LevelOrderWithRightLink(TreeNode<Integer> root) {
		Queue<TreeNode<Integer>> q = new LinkedList<TreeNode<Integer>>();
		int currentLevelNodeCount = 0;
		int nextLevelNodeCount = 0;
		currentLevelNodeCount++;
		q.add(root);
		
		TreeNode<Integer> prev = null;
		
		while(!q.isEmpty()) {
			TreeNode<Integer> node = new TreeNode<Integer>();
			TreeNode<Integer> cur = new TreeNode<Integer>();
			cur = q.peek();
			
			node = q.peek().getLeft();
			if(node != null) {
				q.add(node);	
				nextLevelNodeCount++;
			}
			
			node = q.peek().getRight();
			if(node != null) {
				q.add(node);
				nextLevelNodeCount++;
			}
			
			if(prev != null) {
				prev.setRightLink(cur);
			}
			
			currentLevelNodeCount--;
			prev = cur;
			
			if(currentLevelNodeCount == 0) {
				currentLevelNodeCount = nextLevelNodeCount;
				nextLevelNodeCount = 0;
				prev = null;
			}
			System.out.print(q.remove().getValue()+" ");
		}
		
		return root;
	}

	private static void zigzagTraversal(TreeNode<Integer> root) {
		Stack<TreeNode<Integer>> current = new Stack<TreeNode<Integer>>();
		current.push(root);
		int counter = 1;
		while(true) {
			Stack<TreeNode<Integer>> next = new Stack<TreeNode<Integer>>();
			while(!current.isEmpty()) {
				TreeNode<Integer> popNode = current.pop();
				System.out.print(popNode.getValue()+" ");
				if(counter%2 == 1) {
					if(popNode.getLeft() != null) {
						next.push(popNode.getLeft());
					}
					if(popNode.getRight() != null) {
						next.push(popNode.getRight());
					}
				}else {
					if(popNode.getRight() != null) {
						next.push(popNode.getRight());
					}
					if(popNode.getLeft() != null) {
						next.push(popNode.getLeft());
					}
				}
			}
			
			current = next;
			next = null;
			
			if(current.isEmpty()) {
				break;
			}
			counter++;
		}
	}
	
	public static void main(String[] args) {
		TreeNode<Integer> root = buildTree();
		LevelOrderTraversalTree(root);
		System.out.println();
		zigzagTraversal(root);
		System.out.println();
		root = LevelOrderWithRightLink(root);
		System.out.println();
		System.out.println(root.getLeft().getLeft().getRightLink().getRightLink().getValue());
	}
}
