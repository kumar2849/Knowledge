package map;

import java.util.Iterator;
import java.util.Map.Entry;

public abstract class AbstractMap<K, V> implements Map<K, V> {

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	protected static class MapEntry<K, V> implements Entry<K, V> {
		private K k;
		private V v;

		public MapEntry(K k, V v) {
			super();
			this.k = k;
			this.v = v;
		}

		public void setKey(K k) {
			this.k = k;
		}

		public V setValue(V v) {
			V old = this.v;
			this.v = v;
			return old;
		}

		@Override
		public K getKey() {
			return k;
		}

		@Override
		public V getValue() {
			return v;
		}

	}

	private class KeyIterator implements Iterator<K> {
		private Iterator<Entry<K, V>> entries = entrySet().iterator();

		@Override
		public boolean hasNext() {
			return entries.hasNext();
		}

		@Override
		public K next() {
			return entries.next().getKey();
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	private class KeyIterable implements Iterable<K> {

		@Override
		public Iterator<K> iterator() {
			return new KeyIterator();
		}

	}

	@Override
	public Iterable<K> keySet() {
		return new KeyIterable();
	}

	private class ValueIterator implements Iterator<V> {
		private Iterator<Entry<K, V>> entries = entrySet().iterator();

		@Override
		public boolean hasNext() {
			return entries.hasNext();
		}

		@Override
		public V next() {
			return entries.next().getValue();
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	private class ValueIterable implements Iterable<V> {

		@Override
		public Iterator<V> iterator() {
			return new ValueIterator();
		}

	}

	@Override
	public Iterable<V> values() {
		return new ValueIterable();
	}

	

}
