package list;

public interface List<E> {

	public int size();

	public E get(int index) throws IndexOutOfBoundsException;

	public void add(int index, E e) throws IndexOutOfBoundsException;

	public void set(int index, E e) throws IndexOutOfBoundsException;

	public void remove(int index);

	public boolean isEmpty();

}
