class TreeNode<T> {
	private T value;
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public TreeNode<T> getLeft() {
		return left;
	}
	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}
	public TreeNode<T> getRight() {
		return right;
	}
	public void setRight(TreeNode<T> right) {
		this.right = right;
	}
	private TreeNode<T> left;
	private TreeNode<T> right;
}

public class TreeImplementation {
	

	
	public static void main(String[] args) {
		int rootValue = 1;
		TreeNode<Integer> root = new TreeNode<Integer>();
	}
}
