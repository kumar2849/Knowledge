package sorting;

public class MergeSortList {

	private class Node {
		int value;
		Node next;

		public Node(int value) {

			this.value = value;
		}

	}

	Node head;

	public Node getMiddle(Node head) {
		Node slow = head;
		Node fast = head.next;
		while (fast != null) {
			fast = fast.next;
			if (fast != null) {
				slow = slow.next;
				fast = fast.next;
			}
		}
		return slow;

	}

	public Node mergeSort(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node middle = getMiddle(head);
		Node nextTomiddle= middle.next;
		middle.next=null;
		Node left=mergeSort(head);
		Node rigth= mergeSort(nextTomiddle);
	
		return 	mergeSorted(left, rigth);
	}

	public Node mergeSorted(Node a, Node b) {
		Node result;
		if(a==null){
			return b;
		} else if( b==null){
			return a;
		}
		
		if (a.value<=b.value){
			result= a;
			result.next = mergeSorted(a.next, b);
		} else{
			result =b;
			result.next = mergeSorted(a, b.next);
		}
		
		return result;

	}
	
	public void push(int val){
		Node newNode = new Node(val);
		newNode.next =head;
		head = newNode;
		
	}
	
	public void printList(Node head){
		Node trailer = head;
		while(trailer!=null){
			System.out.println(trailer.value+", ");
			trailer=trailer.next;
		}
		
	}
	public static void main(String[] args) 
    { 
  
		MergeSortList li = new MergeSortList(); 
        /* 
         * Let us create a unsorted linked list to test the functions 
         * created. The list shall be a: 2->3->20->5->10->15 
         */
        li.push(15); 
        li.push(10); 
        li.push(5); 
        li.push(20); 
        li.push(3); 
        li.push(2); 
  
        // Apply merge Sort 
        li.head = li.mergeSort(li.head); 
        System.out.print("\n Sorted Linked List is: \n"); 
        li.printList(li.head); 
    } 
}
