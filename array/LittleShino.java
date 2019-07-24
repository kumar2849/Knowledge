package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LittleShino {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// int[] arr = new int[size];
		String line = br.readLine();
		String[] strs = line.trim().split("\\s+");
		long a = Long.parseLong(strs[0]);
		long b = Long.parseLong(strs[1]);

		int count = 0;
		long n = gcd(a, b);
		for (int i = 1; i <= Math.sqrt(n) + 1; i++) {
			if (n % i == 0) {
				if (n / i == i)
					count += 1;
				else
					count += 2;
			}
		}

		System.out.println(count);

	}

	static long gcd(long a, long b) {
		if (a == 0)
			return b;
		else
			return gcd(b % a, a);
	}
}
