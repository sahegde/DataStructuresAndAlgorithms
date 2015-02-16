package BSTProblems;

import TreeProblems.LevelOrderTraversal;
import TreeProblems.TreeNode;
import TreeProblems.TreeTraversals;

public class ArrayToBST {
	
	private static TreeNode<Integer> convertToBST(int a[],int left, int right) {
		
		if(left > right) {
			 return null;
		}
		else {
			TreeNode<Integer> node = new TreeNode<Integer>();
			int mid = (left+right)/2;
			node.setValue(a[mid]);
			node.setLeft(convertToBST(a, left, mid-1));
			node.setRight(convertToBST(a, mid+1, right));
			return node;
		}
	}
	
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		TreeNode<Integer> root = convertToBST(a,0,a.length-1);
		
		System.out.println("Level Order Traversal: ");
		LevelOrderTraversal.LevelOrderTraversalTree(root);
	}
}
