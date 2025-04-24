package dsa;

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	TreeNode(int data) {
		this.data = data;
	}
}

public class TreeDS {

	private static void printAllData(TreeNode root) {
		if (root == null)
			return;

		if (root.data != 0) {
//			System.out.println(root.data);
			printAllData(root.left);
			printAllData(root.right);
		}
	}

	private static void printParentData(TreeNode root) {
		if (root == null)
			return;

		if (root.left != null || root.right != null) {
//			System.out.println(root.data);
			printParentData(root.left);
			printParentData(root.right);
		}
	}

	private static void printAllParentData(TreeNode root) {
		if (root == null)
			return;

		if (root.left != null || root.right != null) {
			System.out.print("Parent : " + root.data + " and its children - ");
			if (root.left != null)
				System.out.print(root.left.data + " ");
			if (root.right != null)
				System.out.print(root.right.data + " ");
			System.out.println();
		}

		printAllParentData(root.left);
		printAllParentData(root.right);
	}

	private static void printAllLeafData(TreeNode root) {
		if (root == null)
			return;

		if (root.left == null && root.right == null) {
			System.out.println(root.data);
		}
		printAllLeafData(root.left);
		printAllLeafData(root.right);
	}

	/*
	 * InOrder Traversal is used to sort the data in the ascending order or the
	 * descending order. For the below input it will sort the data in the ascending
	 * order. In order Traversal -> left - root - right
	 */
	private static void inOrderTraversal(TreeNode root) {
		if (root == null)
			return;

		inOrderTraversal(root.left);
		System.out.print(root.data + " ");
		inOrderTraversal(root.right);
	}

//	preOrder Traversal ->  - root - left - right
	private static void preOrderTraversal(TreeNode root) {
		if (root == null)
			return;

		System.out.print(root.data + " ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);

	}

//	Postorder Traversal (Left → Right → Root)
	private static void postOrderTraversal(TreeNode root) {
		if (root == null)
			return;

		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.data + " ");
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(7);
		root.right = new TreeNode(13);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(11);
		root.right.right = new TreeNode(14);
		root.left.right.right = new TreeNode(9);
		root.right.left.right = new TreeNode(12);
		printAllData(root);
		printParentData(root);
//		printAllParentData(root);
//		printAllLeafData(root);
//		inOrderTraversal(root);
//		preOrderTraversal(root);
		postOrderTraversal(root);
	}

}
