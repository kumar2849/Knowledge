package queue;

public class SinglyLinkedList<E> {
	private class Node<E> {
		Node<E> next;
		E element;

		public Node(Node<E> next, E element) {
			super();
			this.next = next;
			this.element = element;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public E getElement() {
			return element;
		}

	}

	Node<E> head = null;
	Node<E> tail = null;
	int size = 0;

	public SinglyLinkedList() {
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E getFirst() {
		return head.getElement();
	}

	public void addFirst(E e) {
		head = new Node(head, e);
		if (isEmpty()) {
			tail = head;
		}
		size++;
	}

	public void addLast(E e) {
		Node newest = new Node(null, e);
		if (isEmpty()) {
			head = newest;
		} else {
			tail.setNext(newest);
		}
		tail=newest;
		size++;
	}
	
	public E getLast() {
		return tail.getElement();
	}
	
	public E removeFirst() {
		if(isEmpty()) {
			return null;
		}
		E ans= head.getElement();		
		head=head.getNext();
		size--;
		if(size==0) {
			tail=null;
		}
		return ans;
	}
	
}
