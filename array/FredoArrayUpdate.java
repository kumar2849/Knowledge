package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FredoArrayUpdate {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		// int[] arr = new int[size];
		String line = br.readLine();
		String[] strs = line.trim().split("\\s+");
		int sum = 0;
		for (int i = 0; i < size; i++)
			sum += Integer.parseInt(strs[i]);

		System.out.println((sum / size) + 1);
	}
}
