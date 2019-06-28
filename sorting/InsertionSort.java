package sorting;

public class InsertionSort {
	
	public static void main(String[] args) {
		char[] ch = {'f','e','d','c'} ;
		sort(ch);
		for(int i=0; i<ch.length;i++) {
			System.out.println(ch[i]);
		}
	}
	
	public static void sort(char[] ch) {
		int n = ch.length;
		for (int i =1; i <n; i++) {
			char cur = ch[i];
			int j = i;
			while(j>0 && ch[j-1]>cur) {
				ch[j]=ch[j-1];
				j--;
			}
			ch[j]=cur;
		}
		
	}
}
