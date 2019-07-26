package map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

public abstract class AbstractHashMap<K, V> extends AbstractMap<K, V> {

	protected int capacity;
	private int prime;
	private long scale, shift;
	protected int n = 0;

	public AbstractHashMap(int capacity, int prime) {
		super();
		this.capacity = capacity;
		this.prime = prime;
		Random rand = new Random();
		this.scale = rand.nextInt(prime - 1) + 1;
		this.shift = rand.nextInt(prime);
	}

	public AbstractHashMap(int cap) {
		this(cap, 109345121);
	}

	public AbstractHashMap() {
		this(17);
	}

	public int size() {
		return n;
	}

	private int hashValue(K key) {
		return (int) ((Math.abs(key.hashCode() * scale + shift) % prime) % capacity);
	}

	public V get(K k) {
		return bucketGet(hashValue(k), k);
	}

	public V remove(K key) {
		return bucketRemove(hashValue(key), key);
	}

	public V put(K key, V value) {
		V answer = bucketPut(hashValue(key), key, value);
		if (n > capacity / 2 ) {
			resize(2 * capacity - 1);
		}
		return answer;
	}

	private void resize(int i) {
		List<Entry<K, V>> buffer = new ArrayList<>(n);
		for (Entry<K, V> entry : entrySet()) {
			buffer.add(entry);
		}

		capacity = i;
		createTable();
		for (Entry<K, V> entry : buffer) {
			put(entry.getKey(), entry.getValue());
		}

	}

	protected abstract void createTable();

	protected abstract V bucketGet(int h, K k);

	protected abstract V bucketPut(int h, K k, V v);

	protected abstract V bucketRemove(int h, K k);

}
