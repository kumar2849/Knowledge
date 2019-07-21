package priorityqueue;

public class HeapSortExample {
	public static void main(String[] args) {
		int[] arr = {3,4,8,10,7,9,23,15};
		sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	private static void sort(int[] arr) {
		int n = arr.length;

		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}
		for (int i = n-1 ;i>=0; i--){
			swap(arr,i,0);
			heapify(arr, i, 0);
		}
	}

	private static void heapify(int[] arr, int n, int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		if (l < n && arr[l] > arr[largest]) {
			largest=l;
		}
		if (r < n && arr[r] > arr[largest]) {
			largest=r;
		}
		if(largest!=i){
			swap(arr, largest, i);
			heapify(arr, n, largest);
		}
		
		

	}

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
