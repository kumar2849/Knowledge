package map;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

public class UnsortedMap<K, V> extends AbstractMap<K, V> {
	private List<Entry<K, V>> map = new ArrayList<>();

	public UnsortedMap() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int size() {
		return map.size();
	}

	private int findindex(K k) {
		int n = map.size();
		for (int i = 0; i < n; i++) {
			if (map.get(i).getKey().equals(k)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public V get(K k) {
		int j = findindex(k);
		if (j == -1)
			return null;
		return map.get(j).getValue();
	}

	@Override
	public V put(K k, V v) {
		int j = findindex(k);
		if (j == -1) {
			map.add(new MapEntry<>(k, v));
			return null;
		} else {
			return map.get(j).setValue(v);
		}

	}

	@Override
	public V remove(K k) {
		int j = findindex(k);
		if (j == -1)
			return null;
		int n = map.size();
		V ans = map.get(j).getValue();
		if (j != n - 1)
			map.set(j, map.get(n - 1));

		map.remove(n - 1);

		return ans;

	}

	private class EntryIterator implements Iterator<Entry<K, V>> {
		private int j = 0;

		@Override
		public boolean hasNext() {
			return j < map.size();
		}

		@Override
		public Entry<K, V> next() {
			if (j == map.size())
				throw new NoSuchElementException();
			return map.get(j++);
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	private class EntryIterable  implements Iterable<Entry<K, V>>{

		@Override
		public Iterator<Entry<K, V>> iterator() {
			return new EntryIterator();
		}
		
	}

	@Override
	public Iterable<Entry<K, V>> entrySet() {
		return new EntryIterable();
	}

}
