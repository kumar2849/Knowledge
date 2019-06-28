package recursion;

import java.util.ListIterator;
import java.util.Stack;

public class SortTheStack {
	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(-3);
		s.push(14);
		s.push(18);
		s.push(-5);
		s.push(30);
		s.push(40);
		System.out.println("Before sorting");
		printStack(s);
		sortStack(s);
		System.out.println("after sorting");
		printStack(s);
		
	}
	static void printStack(Stack<Integer> s){
		ListIterator<Integer> lt = s.listIterator();
		while(lt.hasNext()){
			lt.next();
		}
		

	       while(lt.hasPrevious()) 
	           System.out.print(lt.previous()+" ");
	       System.out.println();
	}
	
	static void sortStack(Stack<Integer> s){
		if (!s.isEmpty()){
			int temp = s.pop();
			sortStack(s);
			sortedInsert(s,temp);
			//s.push(temp);
		}
		
	}
	static void sortedInsert(Stack<Integer> s, int item){
		if (s.isEmpty()||item>s.peek()){
			s.push(item);
			return;
		} 
			int temp = s.pop();
			sortedInsert(s, item);
			s.push(temp);
		
	}

}
