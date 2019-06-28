package queue;

public class ArrayDequeue<E> implements Dequeue<E> {

	private final static int MAX = 4;

	private E[] arr;

	private int rear;

	private int front;

	private int size;

	public ArrayDequeue() {
		arr = (E[]) new Object[MAX];
		rear = 0;
		front = -1;
		this.size = MAX;
	}

	@Override
	public void insertFront(E key) throws IllegalArgumentException {

		if (isFull()) {
			throw new IllegalArgumentException("Queue is full");
		}
		if (isEmpty()) {
			front = 0;
			rear = 0;
		} else if (front == 0) {
			front = size - 1;
		} else {
			front = front - 1;
		}
		arr[front] = key;

	}

	@Override
	public void insertRear(E key) throws IllegalArgumentException {
		if (isFull()) {
			throw new IllegalArgumentException("Queue is Full");
		}
		if (isEmpty()) {
			front = 0;
			rear = 0;
		} else if (rear == size - 1) {
			rear = 0;
		} else {
			rear = rear + 1;
		}
		arr[rear] = key;
	}

	@Override
	public E deleteFront() {
		if (isEmpty()) {
			return null;
		} else {
			E ans = arr[front];
			arr[front] = null;
			if (front == rear) {
				front = -1;
				rear = -1;
			} else if (front == size - 1) {				
				front = 0;
			} else {
				front = front + 1;
			}
			return ans;
		}

	}

	@Override
	public E deleteRear() {
		if (isEmpty()) {
			return null;
		} else {
			E ans = arr[rear];
			arr[rear] = null;
			if (front == rear) {
				front = -1;
				rear = -1;
			} else if (rear == 0) {
				rear = size -1 ;
			} else {
				rear = rear-1;
			}
			return ans;
		}
	}

	@Override
	public E getFront() {
		// TODO Auto-generated method stub
		return arr[front];
	}

	@Override
	public E getRear() {
		// TODO Auto-generated method stub
		return arr[rear];
	}

	@Override
	public boolean isFull() {
		return ((front == 0 && rear == size - 1) || (front == rear + 1));
	}

	@Override
	public boolean isEmpty() {
		return (front == -1);
	}

}
