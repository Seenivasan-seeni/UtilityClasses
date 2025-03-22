package dsa;

import java.util.logging.Logger;

class Node {
	int key;
	Node left, right;

	Node(int key) {
		this.key = key;
	}
}

public class BinarySearchTree {

	private final static Logger log = Logger.getLogger(BinarySearchTree.class.getName());

	Node root;

	BinarySearchTree() {
		root = null;
	}

	public Node insertRec(Node root, int key) {
		if (root == null) {
			root = new Node(key);
			return root;
		}
		if (key < root.key)
			root.left = insertRec(root.left, key);
		else
			root.right = insertRec(root.right, key);
		return root;
	}

	public void insert(int key) {
		root = insertRec(root, key);
	}

	public void inOrder() {
		inOrderRec(root);
	}

	public void inOrderRec(Node root) {
		if (root != null) {
			inOrderRec(root.left);
			log.info("Traversal value: " + root.key);
			System.out.println(root.key);
			inOrderRec(root.right);
		}
	}
	
	public void search(int key) {
		System.out.println(searchRec(root, key));
	}

	public int searchRec(Node root, int key) {
		if (root != null) {
			return root.key == key ? root.key : root.key > key ? searchRec(root.left, key) : searchRec(root.right, key);
		}
		return -1;
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(7);
		bst.insert(9);
		bst.insert(3);
		bst.insert(100);
		bst.insert(1);
		System.out.println("InOrder Traversal...");
		bst.inOrder();

		bst.search(77);
	}
}