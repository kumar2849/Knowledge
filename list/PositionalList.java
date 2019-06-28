package list;

public interface PositionalList<E> {
	public boolean isEmpty();

	public int size();

	public Position<E> first();

	public Position<E> last();

	public Position<E> after(Position<E> p) throws IllegalArgumentException;

	public Position<E> before(Position<E> p) throws IllegalArgumentException;

	public Position<E> addFirst(E e);

	public Position<E> addLast(E e);

	public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException;

	public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException;

	public E set(Position<E> p, E e) throws IllegalArgumentException;

	public E remove(Position<E> p) throws IllegalArgumentException;
}
