package Stack;

public interface Stack<E> {
	int size();
	void push(E e);
	E top();
	boolean isEmpty();
	E pop();
}
