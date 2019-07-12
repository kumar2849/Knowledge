package tree;

public interface BinaryTree<E> extends Tree<E> {
	/** Returns the Position of p's left child (or null if no child exists). */
	public Position<E> left(Position<E> p) throws IllegalArgumentException;

	/** Returns the Position of p's right child (or null if no child exists). */
	public Position<E> right(Position<E> p) throws IllegalArgumentException;

	/** Returns the Position of p's sibling (or null if no sibling exists). */
	public Position<E> sibling(Position<E> p) throws IllegalArgumentException;

	/**
	 * Creates a root for an empty tree, storing e as the element, and returns the
	 * position of that root; an error occurs if the tree is not empty.
	 */
	public Position<E> addRoot(E e);

	/*
	 * Creates a left child of position p, storing element e, and returns the
	 * position of the new node; an error occurs if p already has a left child.
	 */
	public Position<E> addLeft(Position<E> p, E e);

	/*
	 * Creates a right child of position p, storing element e, and returns the
	 * position of the new node; an error occurs if p already has a right child.
	 */
	public Position<E> addRight(Position<E> p, E e);

	/*
	 * Replaces the element stored at position p with element e, and returns the
	 * previously stored element.
	 */
	public E set(Position<E> p, E e);
	
	/*
	 * Removes the node at position p, replacing it with its child (if any), and
	 * returns the element that had been stored at p; an error occurs if p has two
	 * children.
	 */
	public E remove(Position<E> p);
	
}
