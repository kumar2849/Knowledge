package tree;

public class TreeTaversal {
	public class Node {
		Node left, right;
		int data;

		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	Node root;

	public void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.println(node.data);
		preOrder(node.left);
		preOrder(node.right);

	}

	public void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.data);
	}
	
	public void inOrder(Node node) {
		if (node ==null){
			return ;
		}
		
		inOrder(node.left);
		
		System.out.println(node.data);
		inOrder(node.right);
	}

	public static void main(String args[]) {
		/*
		 * creating a binary tree and entering the nodes
		 */
		TreeTaversal tree_level = new TreeTaversal();
		tree_level.root = tree_level.new Node(1);
		tree_level.root.left = tree_level.new Node(2);
		tree_level.root.right = tree_level.new Node(3);
		tree_level.root.left.left = tree_level.new Node(4);
		tree_level.root.left.right = tree_level.new Node(5);

		System.out.println("PreOrder traversal of binary tree is - ");
		tree_level.preOrder(tree_level.root);
		
		System.out.println("PostOrder traversal of binary tree is - ");
		tree_level.postOrder(tree_level.root);
		
		System.out.println("In Oder traversal of binary tree is - ");
		tree_level.inOrder(tree_level.root);
	}

}
