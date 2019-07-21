package priorityqueue;

import java.util.Comparator;

import list.LinkedPositionalList;
import list.Position;

public class SortedPriorityQueue<K,V> extends AbstractPriorityQueue<K, V> {
	
	private LinkedPositionalList<Entry<K, V>> list ;
	
	public SortedPriorityQueue() {
		list = new LinkedPositionalList<>();;
	}
	
	public SortedPriorityQueue(Comparator<K> comp){
		super(comp);
	}
	

	@Override
	public Entry<K, V> insert(K k, V v) throws IllegalArgumentException {
		checkKey(k);
		Entry<K, V> newest = new PQEntry<>(k, v);
		Position<Entry<K, V>> walk = list.last();
		while(walk!=null && compare(newest , walk.getElement())<0 ){
			walk=list.before(walk);
			if(walk==null);
				list.addFirst(newest);
			list.addAfter(walk, newest);
		}
		return newest;
	}

	@Override
	public Entry<K, V> min() {
		if(list.isEmpty()) return null;
		return list.first().getElement();
	}

	@Override
	public Entry<K, V> removeMin() {
		if(list.isEmpty()) return null;
		
		return list.remove(list.first());
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}
	

}
