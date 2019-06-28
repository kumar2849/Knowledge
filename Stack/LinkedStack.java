package Stack;



public class LinkedStack<E> implements Stack<E>{
	
	SinglyLinkedList<E> list = new SinglyLinkedList<>();
	public LinkedStack() {
		
	}
	@Override
	public int size() {
		return list.getSize();
	}

	@Override
	public void push(E e) {
		list.addFirst(e);		
	}

	@Override
	public E top() {
		return list.getFirst();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public E pop() {
		return list.remove();
	}

}



