package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class GFG {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t != 0) {
			int size = Integer.parseInt(br.readLine());
			int[] arr = new int[size];
			String line = br.readLine();
			String[] strs = line.trim().split("\\s+");
			for (int i = 0; i < size; i++)
				arr[i] = Integer.parseInt(strs[i]);
			printSumOfArr(arr);
			t--;
		}
	}

	private static void printSumOfArr(int[] arr) {
		int start = 0;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			start += arr[i];
			if (start < 0) {
				start = 0;
			} else if (sum < start) {
				sum = start;
			}
		}
		if (sum == 0) {
			Arrays.sort(arr);
			sum = arr[arr.length - 1];
		}
		System.out.println(sum);
	}

}
