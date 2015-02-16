package TreeProblems;

import java.util.Stack;


public class TreeTraversals {
	
	public static TreeNode<Integer> buildNode(int value) {
		TreeNode<Integer> node = new TreeNode<Integer>();
		node.setValue(value);
		node.setLeft(null);
		node.setRight(null);
		
		return node;
	}
	
	private static TreeNode<Integer> buildTree() {
		TreeNode<Integer> root = buildNode(1);	
		TreeNode<Integer> node2 = buildNode(2);
		TreeNode<Integer> node3 = buildNode(3);
		TreeNode<Integer> node4 = buildNode(4);
		TreeNode<Integer> node5 = buildNode(5);
		TreeNode<Integer> node6 = buildNode(6);
		TreeNode<Integer> node7 = buildNode(7);
		TreeNode<Integer> node8 = buildNode(8);
		
		root.setLeft(node2);
		node2.setLeft(node3);
		node2.setRight(node4);
		node3.setLeft(node5);
		node5.setRight(node6);
		node6.setLeft(node7);
		node6.setRight(node8);
		
		return root;
	}
	private static void preOrderTraversal(TreeNode<Integer> root) {
		if(root != null) {
			System.out.print(root.getValue()+" ");
			preOrderTraversal(root.getLeft());
			preOrderTraversal(root.getRight());
		}
	}
	
	private static void IterativePreTraversal(TreeNode<Integer> root) {
		TreeNode<Integer> node = root;
		Stack<TreeNode<Integer>> s = new Stack<TreeNode<Integer>>();
		while(node != null) {
			s.push(node);
			System.out.print(node.getValue()+" ");
			node = node.getLeft();
			
			while(node == null && !s.isEmpty()) {
				node = s.pop();
				node = node.getRight();
			}
		}
	}
	
	private static void InoderTraversal(TreeNode<Integer> root) {
		if(root != null) {
			InoderTraversal(root.getLeft());
			System.out.print(root.getValue()+" ");
			InoderTraversal(root.getRight());
		}
	}
	
	private static void IterativeInTraversal(TreeNode<Integer> root) {
		TreeNode<Integer> node = root;
		Stack<TreeNode<Integer>> s = new Stack<TreeNode<Integer>>();
		while(node != null) {
			s.push(node);
			node = node.getLeft();
			
			while(node == null && !s.isEmpty()) {
				node = s.pop();
				System.out.print(node.getValue()+" ");
				node = node.getRight();
			}
		}
	}
	
	private static void postOrderTraversal(TreeNode<Integer> root) {
		if(root != null) {
			postOrderTraversal(root.getLeft());
			postOrderTraversal(root.getRight());
			System.out.print(root.getValue()+" ");
		}
	}
	
/*	private static void IterativePostOrderTraversal(TreeNode<Integer> root) {
		TreeNode<Integer> node = root;
		Stack<TreeNode<Integer>> s = new Stack<TreeNode<Integer>>();
		while(true) {
			while(node != null) {
				s.push(node);
				node = node.getLeft();
			}
			
			if(!s.isEmpty())
				node = s.pop();
			
			node = node.getRight();
			if(node != null) {
				s.push(node);
			}
		}
	}*/
	
	public static void main(String[] args) {
		TreeNode<Integer> root = buildTree();
		
		System.out.println("Recursive Traverse preoder");
		preOrderTraversal(root);
		System.out.println("\nIterative preorder traversal");
		IterativePreTraversal(root);
		System.out.println("\nRecursive inorder Traversal");
		InoderTraversal(root);
		System.out.println("\nIterative inorder traversal");
		IterativeInTraversal(root);
		
	}
}
