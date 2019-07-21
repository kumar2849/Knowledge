package priorityqueue;

import java.util.Comparator;

public class DefaultComparator<E> implements Comparator<E> {

	@Override
	public int compare(E a, E b) {
		// TODO Auto-generated method stub
		return ((Comparable<E>) a).compareTo(b);
	}

}
