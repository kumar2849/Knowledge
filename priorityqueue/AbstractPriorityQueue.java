package priorityqueue;

import java.util.Comparator;

public abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V> {
	protected static class PQEntry<K, V> implements Entry<K, V> {
		K k;
		V v;

		public PQEntry(K k, V v) {
			super();
			this.k = k;
			this.v = v;
		}

		public K getK() {
			return k;
		}

		public void setK(K k) {
			this.k = k;
		}

		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return k;
		}

		@Override
		public V getValue() {
			// TODO Auto-generated method stub
			return v;
		}

	}

	private Comparator<K> comp;

	protected AbstractPriorityQueue(Comparator<K> c) {
		this.comp = c;
	}

	protected AbstractPriorityQueue() {
		this(new DefaultComparator<K>());
	}
	
	protected int compare(Entry<K, V> a, Entry<K, V> b){
		return comp.compare(a.getKey(), b.getKey());
	}
	
	protected boolean checkKey(K key) throws IllegalArgumentException{
		try{
			return comp.compare(key, key)==0;
		} catch (ClassCastException e) {
			throw new IllegalArgumentException("Incompatible key");
		}
	}
	
	public boolean isEmpty(){
		return  size()==0;
	}
	
	

}
