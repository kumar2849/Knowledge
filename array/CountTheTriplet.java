package array;

import java.util.Arrays;
import java.util.Scanner;

/*Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains an Integer N denoting size of array and the second line contains N space separated elements.

Output:
For each test case, print the count of all triplets, in new line. If no such triplets can form, print "-1".

Constraints:
1 <= T <= 100
3 <= N <= 105
1 <= A[i] <= 106

Example:
Input:
2
4
1 5 3 2
3
3 2 7
Output:
2
-1

Explanation:
Testcase 1: There are 2 triplets: 1 + 2 = 3 and 3 +2 = 5*/

class CountTheTriplet {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t != 0) {
			int size = sc.nextInt();
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = sc.nextInt();
			}
			int count = 0;
			Arrays.sort(arr);
			for (int i = 0; i < arr.length; i++) {
				int pt = 0;
				int pt2 = arr.length - 1;
				while (pt < pt2) {

					if ((arr[pt] + arr[pt2]) == arr[i]) {
						count++;
						pt++;
						pt2--;
					} else if ((arr[pt] + arr[pt2]) > arr[i]) {
						pt2--;
					}else if ((arr[pt] + arr[pt2]) < arr[i]) {
						pt++;
					}

				}
			}
			if(count==0)
				count =-1;
			System.out.println(count);
			t--;
		}
		sc.close();
	}

}
