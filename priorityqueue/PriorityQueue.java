package priorityqueue;

public interface PriorityQueue<K, V> {
	Entry<K, V> insert(K k, V v) throws IllegalArgumentException;
	Entry<K, V> min();
	Entry<K, V> removeMin();
	boolean isEmpty();
	int size();

}
