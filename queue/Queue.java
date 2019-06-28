package queue;

public interface Queue<E> {

	public int size();

	public void enQueue(E e);

	public E deQueue();

	public E first();

	public boolean isEmpty();
}
