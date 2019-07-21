package priorityqueue;

import java.util.ArrayList;

public class TestClass {
	public static void main(String[] args) {
		HeapPriorityQueue<Integer, Integer> q = new HeapPriorityQueue<>();
		q.insert(1,	1 );
		q.insert(8, 4);
		q.insert(4, 9);
		q.insert(5, 10);		
		q.insert(0, 15);
		for(Entry<Integer, Integer> al:q.heap){
			System.out.println(al.getValue());
		}
		System.out.println(q.min().getValue());
	}

}
