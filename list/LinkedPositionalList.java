package list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedPositionalList<E> implements PositionalList<E>, Iterable<E> {

	private class Node<E> implements Position<E> {

		E element;
		Node<E> next;
		Node<E> prev;

		public Node(E element, Node<E> prev, Node<E> next) {
			super();
			this.element = element;
			this.next = next;
			this.prev = prev;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}

		public Node<E> getPrev() {
			return prev;
		}

		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}

		public void setElement(E element) {
			this.element = element;
		}

		@Override
		public E getElement() throws IllegalStateException {
			// TODO Auto-generated method stub
			return element;
		}

	}

	private class PostionalIterator implements Iterator<Position<E>> {
		Position<E> cursor = first();
		Position<E> current = null;

		@Override
		public boolean hasNext() {
			return cursor != null;
		}

		@Override
		public Position<E> next() throws NoSuchElementException {
			if (cursor == null)
				throw new NoSuchElementException("nothing left");
			current = cursor;
			if (cursor == last()) {
				cursor = null;
			} else {
				cursor = after(cursor);
			}
			return current;
		}

		public void remove() throws IllegalStateException {
			if (current == null)
				throw new IllegalStateException("nothing left");
			LinkedPositionalList.this.remove(current);
			current = null;
		}

	}

	private class PostionIterable implements Iterable<Position<E>> {

		@Override
		public Iterator<Position<E>> iterator() {
			return new PostionalIterator();
		}

	}

	public Iterable<Position<E>> position() {
		return new PostionIterable();
	}

	private class ElementIterator implements Iterator<E> {
		// Iterator<Position<E>> itr = (Iterator<Position<E>>) position();
		Iterator<Position<E>> itr = new PostionalIterator();

		@Override
		public boolean hasNext() {
			return itr.hasNext();
		}

		@Override
		public E next() {

			return itr.next().getElement();
		}

		public void remove() {
			itr.remove();
		}

	}

	@Override
	public Iterator<E> iterator() {
		return new ElementIterator();
	}

	Node<E> header;
	Node<E> trailer;
	int size = 0;

	public LinkedPositionalList() {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	private Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if (!(p instanceof Node))
			throw new IllegalArgumentException("invalid position");

		Node<E> node = (Node<E>) p;
		if (node.getNext() == null)
			throw new IllegalArgumentException("position is not available");
		return node;

	}

	@Override
	public Position<E> first() {
		return (Position<E>) header.getNext();
	}

	@Override
	public Position<E> last() {
		return (Position<E>) trailer.getPrev();
	}

	@Override
	public Position<E> after(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getNext();
	}

	@Override
	public Position<E> before(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getPrev();
	}

	private Position<E> addBetween(Node<E> next, Node<E> prev, E e) {
		Node<E> newNode = new Node<>(e, prev, next);
		next.setPrev(newNode);
		prev.setNext(newNode);
		size++;
		return (Position<E>) newNode;
	}

	@Override
	public Position<E> addFirst(E e) {
		return addBetween(header.getNext(), header, e);
	}

	@Override
	public Position<E> addLast(E e) {
		return addBetween(trailer, trailer.getPrev(), e);
	}

	@Override
	public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return addBetween(node, node.prev, e);
	}

	@Override
	public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return addBetween(node.getNext(), node, e);
	}// TODO Auto-generated method stub

	@Override
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		E answer = node.getElement();
		node.setElement(e);
		return answer;
	}

	@Override
	public E remove(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		E answer = node.getElement();
		Node<E> prev = node.getPrev();
		Node<E> next = node.getNext();
		prev.setNext(next);
		next.setPrev(prev);
		size--;
		node.setNext(null);
		node.setPrev(null);
		node.setElement(null);

		return answer;
	}

}
