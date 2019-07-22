package tree;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
	private class Node<E> implements Position<E> {
		Node<E> left;
		Node<E> rigth;
		Node<E> parent;
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

		public void setLeft(Node<E> left) {
			this.left = left;
		}

		public Node<E> getRigth() {
			return rigth;
		}

		public void setRigth(Node<E> rigth) {
			this.rigth = rigth;
		}

		public Node<E> getParent() {
			return parent;
		}

		public void setParent(Node<E> parent) {
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

	public LinkedBinaryTree() {
	}

	private Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if (!(p instanceof Node)) {
			throw new IllegalArgumentException("Not valid position type");
		}
		Node<E> node = (Node<E>) p;
		if (node.getParent() == node) {
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
		if (node.getLeft() != null) {
			count++;
		}
		if (node.getRigth() != null) {
			count++;
		}
		return count;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterable<Position<E>> positions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> addRoot(E e) {
		if (!isEmpty())
			throw new IllegalStateException("Tree is not empty");
		root = createNode(null, null, null, e);
		size = 1;
		return root;
	}

	@Override
	public Position<E> addLeft(Position<E> p, E e) {
		Node<E> parent = validate(p);
		if (parent.getLeft() != null)
			throw new IllegalArgumentException("p already has a left child");
		Node<E> child = createNode(null, null, parent, e);
		parent.setLeft(child);
		size++;
		return child;
	}

	@Override
	public Position<E> addRight(Position<E> p, E e) {
		Node<E> parent = validate(p);
		if (parent.getRigth() != null)
			throw new IllegalArgumentException("p already has a Rigth child");
		Node<E> child = createNode(null, null, parent, e);
		parent.setRigth(child);
		size++;
		return child;
	}

	@Override
	public E set(Position<E> p, E e) {
		Node<E> node = validate(p);
		E ans = node.getElement();
		node.setElement(e);
		return ans;
	}
	

	@Override
	public E remove(Position<E> p) {
		Node<E> node = validate(p);
		if(numChild(node)==2) {
			throw new IllegalArgumentException("p has two children");
		}
		Node<E> child = (node.getLeft()!=null?node.getLeft( ) : node.getRigth() );
		if(child!=null) {
			child.setParent(node.getParent());
		}
		if(node == root) {
			root=child;
		} else {
			Node<E> parent = node.getParent();
			if (node == parent.getLeft()) {
				parent.setLeft(child);
			} else {
				parent.setRigth(child);
			}
		}
		
		size--;
		E ans = node.getElement();
		node.setElement(null); // help garbage collection
		node.setLeft(null);
		node.setRigth(null);
		node.setParent(node);
		return ans;
	}

}
