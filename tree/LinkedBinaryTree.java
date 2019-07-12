package tree;

import java.util.Iterator;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
	private class Node<E> implements Position<E> {
		Node left;
		Node rigth;
		Node parent;
		E element;

		public Node(Node<E> left, Node<E> rigth, Node<E> parent, E element) {
			super();
			this.left = left;
			this.rigth = rigth;
			this.parent = parent;
			this.element = element;
		}

		public Node<E> getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node<E> getRigth() {
			return rigth;
		}

		public void setRigth(Node rigth) {
			this.rigth = rigth;
		}

		public Node<E> getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		public E getElement() {
			return element;
		}

		public void setElement(E element) {
			this.element = element;
		}

	}

	protected Node<E> createNode(Node<E> left, Node<E> right, Node<E> parent, E e) {
		return new Node<E>(left, right, parent, e);
	}

	private Node<E> root = null;
	private int size = 0;
	
	public LinkedBinaryTree( ) { }
	
	private Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if(! (p instanceof Node)) {
			throw new IllegalArgumentException("Not valid position type");
		} 
		Node<E> node = (Node<E>)p;
		if (node.getParent()==node) {
			throw new IllegalArgumentException("p is no longer in the tree");
		}
		return node;
	}

	@Override
	public Position<E> left(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getLeft();
	}

	@Override
	public Position<E> right(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getRigth();
	}

	@Override
	public Position<E> root() {
		return root;
	}

	@Override
	public Position<E> parent(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getParent();
	}

	@Override
	public int numChildren(Position<E> p) throws IllegalArgumentException {
		int count = 0;
		Node<E> node = validate(p);
		if(node.getLeft()!=null) {
			count++;
		} 
		if (node.getRigth()!=null) {
			count++;
		}
		return count;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Position<E>> positions() {
		// TODO Auto-generated method stub
		return null;
	}

}
