package search;

public class BinarySearch {
	
	public static void main(String[] args) {
		int[] data = {3,5,7,19,40,300,400};
		System.out.println(search(data, 0, data.length-1, 40));
	}

	public static boolean search(int[] data, int low, int high, int target) {
		if (low > high) {
			return false;
		} else {
			int mid = (low + high) / 2;
			if (data[mid]==target) {
				return true;
			}else if (data[mid] > target) {
				return search(data, low, mid-1, target);
			} else {
				return search(data, mid+1, high, target);
			}
		}

	}
}
