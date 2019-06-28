package list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> ,Iterable<E>{
	
	
	private class ArrayListIterator implements Iterator<E>{
		private int j = 0;
		
		private boolean removable = false;
		

		@Override
		public boolean hasNext() {
			return j<size;
		}

		@Override
		public E next() throws NoSuchElementException {
			if(j== size) throw new NoSuchElementException("No next element");
			removable=true;
			return arr[j++];
		}
		
		public void remove() throws IllegalStateException{
			if(!removable)throw new IllegalStateException("Element is not removable");
			ArrayList.this.remove(j-1);
			j--;
			removable = false;
		
		}
		
		
	}
	public Iterator<E> iterator(){
		return new ArrayListIterator();
	}
	private static final int CAPACITY = 10;
	E[] arr;
	int size = 0;

	public ArrayList() {
		this(CAPACITY);
	}

	public ArrayList(int capacity) {
		arr = (E[]) new Object[capacity];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		checkIndex(index, size);
		return arr[index];
	}

	@Override
	public void add(int index, E e) throws IndexOutOfBoundsException, IllegalStateException {
		checkIndex(index, size + 1);
		if (size == arr.length) {
			throw new IllegalStateException("List is full");
		}
		for (int k = size - 1; k >= index; k--) {
			arr[k+1] = arr[k];
		}

		arr[index] = e;
		size++;

	}

	@Override
	public void set(int index, E e) throws IndexOutOfBoundsException {
		checkIndex(index, size);
		arr[index] = e;

	}

	@Override
	public void remove(int index) {
		checkIndex(index, size);
		for (int k = index; k < size - 1; k++) {
			arr[k] = arr[k + 1];
		}
		arr[size - 1] = null;
		size--;

	}

	@Override
	public boolean isEmpty() {

		return size == 0;
	}

	private void checkIndex(int index, int n) throws IndexOutOfBoundsException {
		if (index < 0 || index > n) {
			throw new IndexOutOfBoundsException("Illegal index: " + index);
		}
	}

}
