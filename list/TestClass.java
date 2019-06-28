package list;

import java.util.Iterator;

public class TestClass {
	public static void main(String[] args) {
		/*ArrayList<Integer> list = new ArrayList<>();
		list.add(0, 2);
		list.add(1, 4);
		list .add(0, 5);
		Iterator<Integer> itr = list.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}*/
		
		
		
		
		
		LinkedPositionalList<Integer> list = new LinkedPositionalList<>();
		
		Position<Integer> p = list.addLast(8);
		//System.out.println(list.first().getElement());
		Position<Integer> q= list.addAfter(p, 10);
		list.before(q);
		Position<Integer> r = list.addBefore(q, 3);
		//System.out.println(r.getElement());
		//System.out.println(list.size);
		//list.remove(r);
		//System.out.println(list.remove(r));
		//System.out.println(list.size);
		//System.out.println(list.first().getElement());
		//System.out.println(list.last().getElement());
		
		/*Iterator<Integer> itr = list.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}*/
		
		for(int i : list){
			System.out.println(i);
		}
			
	}
}
