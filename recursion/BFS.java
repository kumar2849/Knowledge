package recursion;

import java.util.Arrays;
import java.util.Random;

public class BFS {
	public static void main(String[] args) {
		int[] arr = new int[10];
		Random r = new Random();
		for(int i =0; i <arr.length; i ++){
			arr[i]= r.nextInt(10);
			System.out.println(arr[i]);
		}
		Arrays.sort(arr);
		System.out.println("Sorted Array");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println(binarySearch(arr, 4, 0, arr.length-1));;
	}
	
	private static boolean binarySearch(int[] arr, int target, int min, int max){
		if(min>max){
			return false;
		} else {
			int mid = (min+max)/2;
			if (target==arr[mid]){
				return true;
			} else if (target>arr[mid]){
				return binarySearch(arr, target, mid+1, max);
			} else{
				return binarySearch(arr, target, min, mid-1);
			}
		}
	}

}
