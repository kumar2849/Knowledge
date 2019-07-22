package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BFSTreeTraversal {
	public  class Node {
		Node left, right;
		int data;
		public Node(int data) {
			this.data = data;
			left=right=null;
		}
	}
	
	Node root;
	
	public void printLevelOrder()  {
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			Node temp = q.poll();
			System.out.println(temp.data);
			if(temp.left!=null) {
				q.add(temp.left);
			} 
			if (temp.right!=null) {
				q.add(temp.right);
			}
			
		}
		
	}
	 public static void main(String args[])  
	    { 
	        /* creating a binary tree and entering  
	         the nodes */
		 	BFSTreeTraversal tree_level = new BFSTreeTraversal(); 
	        tree_level.root = tree_level.new Node(1) ;
	        tree_level.root.left = tree_level.new Node(2); 
	        tree_level.root.right = tree_level.new Node(3); 
	        tree_level.root.left.left = tree_level.new Node(4); 
	        tree_level.root.left.right = tree_level.new Node(5); 
	  
	        System.out.println("Level order traversal of binary tree is - "); 
	        tree_level.printLevelOrder(); 
	    } 

}
