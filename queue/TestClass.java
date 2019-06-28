package queue;

public class TestClass {
	public static void main(String[] args) {
		 Dequeue<Integer> dq = new ArrayDequeue<>(); 
         
         System.out.println("Insert element at rear end  : 5 "); 
         dq.insertRear(5); 
           
         System.out.println("insert element at rear end : 10 "); 
         dq.insertRear(10); 
         
         dq.insertFront(1);
         dq.insertRear(16);
           
         System.out.println("get rear element : "+ dq.getRear()); 
           
         dq.deleteRear(); 
         System.out.println("After delete rear element new rear become : " +  
                                dq.getRear()); 
           
         System.out.println("inserting element at front end"); 
         dq.insertFront(15); 
           
         System.out.println("get front element: " +dq.getFront()); 
           
         dq.deleteFront(); 
           
         System.out.println("After delete front element new front become : " + 
                                    +  dq.getFront()); 
	}
}
