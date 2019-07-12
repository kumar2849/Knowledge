package tree;

public abstract class AbstractTree<E> implements Tree<E> {
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

}
