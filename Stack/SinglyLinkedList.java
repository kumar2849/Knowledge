package Stack;

public class SinglyLinkedList<E> {
	private static class Node<E>{
		Node<E> next;
		E element;
		public Node (Node<E> next, E e){
			this.next= next;
			this.element= e;
		}
		public Node<E> getNext() {
			return next;
		}
		
		public E getElement() {
			return element;
		}
	}
	Node<E> head=null;
	Node<E> tail=null;
	int size =0;
	
	public SinglyLinkedList() {
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	
	public E getFirst(){
		return head.getElement();
	}
	
	public void addFirst(E e){
		head = new Node<>(head, e);
		if(size==0){
			tail=head;
		}
		size++;
	}
	
	public E remove(){
		if (isEmpty()){
			return null;
		}
		E ans = head.getElement();
		head=head.next;
		size--;
		if(size==0)
			tail=null;
		return ans;		
	}
	
}
