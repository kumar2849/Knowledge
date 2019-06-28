package queue;

public interface Dequeue<E> {
	public void insertFront(E key);

	public void insertRear(E Key);

	public E deleteFront();

	public E deleteRear();

	public E getFront();

	public E getRear();

	public boolean isFull();

	public boolean isEmpty();
}
