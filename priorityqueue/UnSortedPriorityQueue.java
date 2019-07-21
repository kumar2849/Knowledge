package priorityqueue;

import java.util.Comparator;

import list.LinkedPositionalList;
import list.Position;

public class UnSortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> implements PriorityQueue<K, V> {
	
	private LinkedPositionalList<Entry<K, V>> list;
	
	public UnSortedPriorityQueue() {
		list=new LinkedPositionalList<>();
	}
	
	public UnSortedPriorityQueue(Comparator<K> comp){
		super(comp);
	}

	@Override
	public Entry<K, V> insert(K k, V v) throws IllegalArgumentException {
		checkKey(k);
		Entry<K, V> newest = new PQEntry<>(k, v);
		list.addLast(newest);
		return newest;
	}
	
	private Position<Entry<K, V>> findMin(){
		Position<Entry<K, V>> small = list.first();
		for (Position<Entry<K, V>> walk: list.position()) {
			if(compare(walk.getElement(), small.getElement())<0){
				small=walk;
			}
			
		}
		return small;
		
	}
	@Override
	public Entry<K, V> min() {
		if(isEmpty()){
			return null;
		}
		return findMin().getElement();
	}

	@Override
	public Entry<K, V> removeMin() {
		if(isEmpty()){
			return null;
		}
		return list.remove(findMin());
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}
}
