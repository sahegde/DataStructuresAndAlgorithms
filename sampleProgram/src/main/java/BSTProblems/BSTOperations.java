package BSTProblems;

import TreeProblems.LevelOrderTraversal;
import TreeProblems.TreeNode;
import TreeProblems.TreeTraversals;

public class BSTOperations {

	private static void insertIntoBST(TreeNode<Integer> current,
			TreeNode<Integer> next, Integer data) {
		if (next == null) {
			if (data >= current.getValue()) {
				current.setRight(TreeTraversals.buildNode(data));
				return;
			} else {
				current.setLeft(TreeTraversals.buildNode(data));
				return;
			}
		}

		if (data >= next.getValue()) {
			current = next;
			next = next.getRight();
			insertIntoBST(current, next, data);
		} else {
			current = next;
			next = next.getLeft();
			insertIntoBST(current, next, data);
		}
	}

	private static Integer findMaxElement(TreeNode<Integer> root) {
		if (root == null) {
			return null;
		}

		while (root.getRight() != null) {
			root = root.getRight();
		}

		return root.getValue();
	}

	private static TreeNode<Integer> findMaxElementRecur(TreeNode<Integer> root) {

		if (root == null) {
			return root;
		}

		if (root.getRight() != null)
			root = findMaxElementRecur(root.getRight());

		return root;

	}

	private static TreeNode<Integer> findMinElementRecur(TreeNode<Integer> root) {

		if (root == null) {
			return root;
		}

		if (root.getLeft() != null)
			root = findMinElementRecur(root.getLeft());

		return root;
	}

	private static Integer findMinElement(TreeNode<Integer> root) {
		if (root == null) {
			return null;
		}

		while (root.getRight() != null) {
			root = root.getLeft();
		}

		return root.getValue();
	}

	private static TreeNode<Integer> find(TreeNode<Integer> root, int value) {
		if(root == null) {
			return null;
		}
		
		if(value > root.getValue()) {
			root = find(root.getRight(),value);
		}else if(value < root.getValue()) {
			root = find(root.getLeft(),value);
		}
		return root;
	}

	private static TreeNode<Integer> findInorderSucc(TreeNode<Integer> root,int value) {
		if (root == null) {
			return null;
		}
		TreeNode<Integer> searchNode = find(root, value);
		
		return findMinElementRecur(searchNode.getRight());
	}

	
	private static TreeNode<Integer> findInorderPred(TreeNode<Integer> root,int value) {
		if (root == null) {
			return null;
		}
		TreeNode<Integer> searchNode = find(root, value);
		
		return findMaxElementRecur(searchNode.getLeft());
	}
	
	private static void deleteFromBST(TreeNode<Integer> root, int value) {
		if(root == null) {
			return;
		}
		TreeNode<Integer> cur = root;
		TreeNode<Integer> next = root;
		while(true) {
			if(next == null) {
				System.out.println("Node to be deleted not found ");
				return;
			}
			if(value == next.getValue()) {
				break;
			}
			while(value > next.getValue()) {
				cur = next;
				next = next.getRight();
			}
			while(value < next.getValue()) {
				cur = next;
				next = next.getLeft();
			}
		}
		
		if(next.getLeft() == null && next.getRight() == null) {
			if(cur.getLeft() == next) {
				cur.setLeft(null);
			}else {
				cur.setRight(null);
			}
		}else if(next.getLeft() == null || next.getRight() == null) {
			if(cur.getLeft() == next) {
				cur.setLeft(next.getLeft() != null ? next.getLeft() : next.getRight());
			}else if(cur.getRight() == next) {
				cur.setRight(next.getLeft() != null ? next.getLeft() : next.getRight());
			}
		}else {
			TreeNode<Integer> replacementNode = findInorderSucc(next, next.getValue());
			TreeNode<Integer> replacementNode1 = TreeTraversals.buildNode(replacementNode.getValue());
			if(cur.getLeft() == next) {
				deleteFromBST(next, replacementNode.getValue());
				replacementNode1.setLeft(next.getLeft());
				replacementNode1.setRight(next.getRight());
				cur.setLeft(replacementNode1);
			}else if(cur.getRight() == next) {
				deleteFromBST(next, replacementNode.getValue());
				replacementNode1.setLeft(next.getLeft());
				replacementNode1.setRight(next.getRight());
				cur.setRight(replacementNode1);
			}
		}
		next = null;
	}
	
		
	public static void main(String[] args) {
		TreeNode<Integer> root = TreeTraversals.buildNode(5);
		insertIntoBST(root, root, 2);
		insertIntoBST(root, root, 8);
		insertIntoBST(root, root, 4);
		insertIntoBST(root, root, 1);
		insertIntoBST(root, root, 12);
		insertIntoBST(root, root, 7);
		insertIntoBST(root, root, 11);
		insertIntoBST(root, root, 14);
		insertIntoBST(root, root, 13);
		insertIntoBST(root, root, 15);

		System.out.println("Level order traversal of BST :");
		LevelOrderTraversal.LevelOrderTraversalTree(root);

		System.out.println("\nMax and Min elements through iteration: ");
		System.out.println("Max :" + findMaxElement(root) + " Min :"
				+ findMinElement(root));

		System.out.println("Max and Min elements through Recursion: ");
		System.out.println("Max :" + findMaxElementRecur(root).getValue()
				+ " Min :" + findMinElementRecur(root).getValue());

		System.out.println("\nInorder pred of: 5:" + findInorderPred(root,5).getValue());
		System.out.println("\nInorder pred of: 8:" + findInorderPred(root,8).getValue());
		
		System.out.println("\nInorder succ of: 5:" + findInorderSucc(root,5).getValue());
		System.out.println("\nInorder succ of: 8:" + findInorderSucc(root,8).getValue());
		
		System.out.println("\nDelete from BST 11: ");
		deleteFromBST(root, 11);
		LevelOrderTraversal.LevelOrderTraversalTree(root);
		
		System.out.println("\nInsert into BST 11: ");
		insertIntoBST(root, root, 11);
		LevelOrderTraversal.LevelOrderTraversalTree(root);
		
		System.out.println("\nDelete from BST 14: ");
		deleteFromBST(root, 14);
		LevelOrderTraversal.LevelOrderTraversalTree(root);
		
		System.out.println("\nDelete from BST 12: ");
		deleteFromBST(root, 12);
		LevelOrderTraversal.LevelOrderTraversalTree(root);

	}
}
