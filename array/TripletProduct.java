package array;

public class TripletProduct {

	public static int product(int[] arr) {

		int[] final_array = new int[3];
		int max = arr[0];

		for (int i = 0; i <= arr.length - 1; i++) {
			if (max < arr[i]) {
				final_array[0] = arr[i];
				max = arr[i];
			}
		}
		max = arr[0];
		for (int i = 0; i <= arr.length - 1; i++) {

			if (!(max == final_array[0]) && final_array[0] > arr[i] && max > arr[i]) {
				final_array[1] = max;
			} else if (max < arr[i] && final_array[0] > arr[i]) {
				final_array[1] = arr[i];
				max = arr[i];
			}

		}
		max = arr[0];
		for (int i = 0; i <= arr.length - 1; i++) {
			if (max != final_array[0]&&max!=final_array[1]) {
				if (!(max == final_array[0]) && !(max == final_array[1]) && final_array[1] > arr[i]
						&& final_array[0] > arr[i] && max > arr[i]) {
				} else if (max < arr[i] && final_array[0] > arr[i] && final_array[1] > arr[i]) {
					max = arr[i];
				}
				
			} else {
				max = arr[i];
			}
		}
		return max * final_array[1] * final_array[0];

	}

	public static void main(String[] args) {
		int[] arr = {1, -4, 3, -6, 7, 0 };

		System.out.println(product(arr));
	}

}
