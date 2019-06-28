package queue;

public class ArrayQueue<E> implements Queue<E> {
	
	private final static int CAPACITY = 10;
	private  E[] data; 
	private  int f = 0;
	private  int size = 0;
	public ArrayQueue() {
		this(CAPACITY);
	}

	public ArrayQueue(int capacity) {
		data=(E[])new Object[capacity];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void enQueue(E e) throws IllegalArgumentException {
		if(size==data.length) {
			throw new IllegalArgumentException("Queue is full");
		}
		int avail=(f+size)%data.length;
		data[avail]=e;
		size++;
	}

	@Override
	public E deQueue() {
		if(isEmpty()) {
			return null;
		}
		E ans= data[f];
		data[f]=null;
		f=(f+1)%data.length;
		size--;
		return ans;
	}

	@Override
	public E first() {
		return data[f];
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

}
