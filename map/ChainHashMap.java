package map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class ChainHashMap<K, V> extends AbstractHashMap<K, V> {

	private UnsortedMap<K, V>[] table;

	public ChainHashMap() {
		super();
	}

	public ChainHashMap(int cap) {
		super(cap);
	}

	public ChainHashMap(int cap, int prime) {
		super(cap, prime);
	}

	@Override
	protected void createTable() {
		table = (UnsortedMap<K,V>[]) new UnsortedMap [capacity];	

	}

	@Override
	protected V bucketGet(int h, K k) {
		UnsortedMap<K,V> bucket = table[h];
		if (bucket == null) return null;
		return bucket.get(k);
	}

	@Override
	protected V bucketPut(int h, K k, V v) {
		UnsortedMap<K,V> bucket = table[h];
		if (bucket == null) {
			bucket=table[h]= new UnsortedMap<>();					
		}
		int oldSize = bucket.size( );
		V ans = bucket.put(k, v);
		n+=bucket.size()-oldSize;
		return ans;
	}

	@Override
	protected V bucketRemove(int h, K k) {
		UnsortedMap<K,V> bucket = table[h];
		if (bucket==null) {
			return null;
		}
		int oldSize = bucket.size( );
		V ans = bucket.remove(k);
		n -= oldSize-bucket.size();
		return ans;
	}

	@Override
	public Iterable<Entry<K, V>> entrySet() {
		List<Entry<K,V>> buffer = new ArrayList<>( );
		for(int i = 0; i <capacity ; i++) {
			if (table[i]!= null) {
				for (Entry<K, V>entry:table[i].entrySet()) {
					buffer.add(entry);
				}
			}
		}
		return buffer;
	}

}
