package tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractTree<E> implements Tree<E> {
	
	public class ElementIterator implements Iterator<E>{
		Iterator<Position<E>> p = positions().iterator();

		@Override
		public boolean hasNext() {
			return p.hasNext();
		}

		@Override
		public E next() {
			return p.next().getElement();
		}
		
		@Override
		public void remove() {
			p.remove();
		}
		
	}
	public boolean isEmpty( ) {
		return size()==0;
	}
	public boolean isInternal(Position<E> p) throws IllegalArgumentException{
		return numChildren(p)>0;
	}
	public boolean isExternal(Position<E> p) throws IllegalArgumentException{
		return numChildren(p)==0;
	}
	public boolean isRoot(Position<E> p) throws IllegalArgumentException{
		return p==root();
	}
	
	public int depth(Position<E> p) {
		if (p==root()) {
			return 0;
		} else {
			return 1+depth(parent(p));
		}
	}
	
	private int badheight() {
		int h = 0;
		for (Position<E> position:positions()) {
			if (isExternal(position)) {
				h=Math.max(h, depth(position));
			}
		}
		return h;
	}
	
	public int height(Position<E> p) {
		int h = 0;
		for (Position<E> c:children(p)) {
			h= Math.max(h, 1+height(c));
		}
		return h;
		
	}
	
	@Override
	public Iterator<E> iterator() {
		return new ElementIterator();
	}
	
	@Override
	public Iterable<Position<E>> positions() {
		return preOrder();
	}
	private  Iterable<Position<E>> preOrder(){
		
		List<Position<E>> snapshot = new ArrayList<>( );
		if (!isEmpty( )) {
			preSubOrder(root(), snapshot);
		}
		return snapshot;
		
	}
	private void preSubOrder(Position<E> root, List<Position<E>> snapshot) {
		snapshot.add(root);
		for(Position<E> child : children(root)) {
			preSubOrder(child, snapshot);
		}
		
	}
	
	

}
