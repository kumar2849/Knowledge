package tree;

import java.util.List;
import java.util.ArrayList;



public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {

	@Override
	public Position<E> sibling(Position<E> p) throws IllegalArgumentException {
		Position<E> parent = parent(p);
		if (parent == null)
			return null;
		if (p == left(parent)) {
			return left(parent);
		} else {
			return right(parent);
		}
	}

	public int numChild(Position<E> p) {
		int count = 0;
		if (left(p) != null) {
			count++;
		}
		if (right(p) != null) {
			count++;
		}
		return count;
	}
	
	public Iterable<Position<E>> children(Position<E> p){
		
		List<Position<E>> snapshot = new ArrayList<>(2);
		if(left(p)!=null) {
			snapshot.add(left(p));
		}
		if(right(p)!=null) {
			snapshot.add(right(p));
		}
		return snapshot;
		
	}

}
