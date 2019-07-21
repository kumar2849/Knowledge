package priorityqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {

	protected List<Entry<K, V>> heap = new ArrayList<>();

	public HeapPriorityQueue() {
		super();
	}
	
	public HeapPriorityQueue(K[] k,V[] v){
		int n = Math.min(k.length, v.length);
		for (int i = 0; i < v.length; i++) {
			heap.add(new PQEntry<>(k[i], v[i]));
		}
		heapify(heap);
	}

	private void heapify(List<Entry<K, V>> heap) {
		int index = heap.size()-1;
		for(int j = index ;j>=0; j--)
		downHeap(0);
	}

	public HeapPriorityQueue(Comparator<K> comp) {
		super(comp);
	}

	private int parent(int j) {
		return (j - 1) / 2;
	}

	private int left(int j) {
		return (2 * j) + 1;
	}

	private int rigth(int j) {
		return (2 * j) + 2;
	}

	private boolean hasLeft(int j) {
		return (j < heap.size());
	}

	private boolean hasRigth(int j) {
		return (j < heap.size());
	}

	private void swap(int i, int j) {
		Entry<K, V> temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}

	private void upHeap(int j) {
		while (j > 0) {
			int p = parent(j);
			if (compare(heap.get(j), heap.get(p)) >= 0)
				break;
			swap(p, j);
			j = p;

		}
	}
	
	private void downHeap(int j){
		while(hasLeft(j)){
			int leftIndex = left(j);
			int smallestIndex = left(j);
			if(hasRigth(j)){
				int rigthIndex= rigth(j);
				if(compare(heap.get(leftIndex),heap.get(rigthIndex))>0){
					smallestIndex=rigthIndex;
				}
			}
			if(compare(heap.get(smallestIndex), heap.get(j))>=0)
				break;
			swap(smallestIndex, j);
			j=smallestIndex;
		}
		
	}

	@Override
	public Entry<K, V> insert(K k, V v) throws IllegalArgumentException {
		checkKey(k);
		Entry<K, V> newest = new PQEntry<>(k, v);
		heap.add(newest);
		upHeap(heap.size()-1);
		return newest;
	}

	@Override
	public Entry<K, V> min() {
		if(heap.isEmpty())
		return null;
		return heap.get(0);
	}

	@Override
	public Entry<K, V> removeMin() {
		if(heap.isEmpty())
		return null;
		
		Entry<K, V> removed = heap.get(0);
		swap(0, heap.size()-1);
		heap.remove(heap.size()-1);
		downHeap(0);
		return removed;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return heap.size();
	}

}
