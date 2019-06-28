package queue;

public class LinkedQueue<E> implements Queue<E>{
	
	SinglyLinkedList<E> list= new SinglyLinkedList<>();

	@Override
	public int size() {
		return list.getSize();
	}

	@Override
	public void enQueue(E e) {
		list.addLast(e);
		
	}

	@Override
	public E deQueue() {
		// TODO Auto-generated method stub
		return list.removeFirst();
	}

	@Override
	public E first() {
		return list.getFirst();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
	}

}
