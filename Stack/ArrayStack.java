package Stack;

public class ArrayStack<E> implements Stack<E>{
	
	private final static int CAPACITY=1000;
	E[] arr;
	int t =-1;
	public  ArrayStack() {
		this(CAPACITY);
	}

	public ArrayStack(int capacity) {
		arr =(E[]) new Object[capacity];
	}

	@Override
	public int size() {
		return t+1;
	}

	@Override
	public void push(E e) throws IllegalArgumentException {
		if(arr.length==size()) {
			throw new IllegalArgumentException("capacity exceeded");
		}
		arr[++t]=e;
		
	}

	@Override
	public E top() {
		if(isEmpty())return null;
		return arr[t];
	}

	@Override
	public boolean isEmpty() {
		return t==-1;
	}

	@Override
	public E pop() {
		if (isEmpty()) {
			return null;
		}
		E element = arr[t];
		arr[t]=null;
		t--;
		return element;
	}

}
