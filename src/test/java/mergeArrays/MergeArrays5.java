package mergeArrays;

import java.util.Arrays;

public class MergeArrays5 {
	/*
	 * Maneesh's Solution!
	 */

	public static void main(String[] args) {

		// Merge Array using only one loop
		int a[] = { 7, 11, 26, 31, 67, 84, 99, 500, 1000 };
		int b[] = { 1, 19, 21, 50, 100, 200 };

		int loopLimit = a.length + b.length;

//		int c[] = new int[loopLimit + 1];
		int c[] = new int[loopLimit]; // correction
		int i = 0;
		int j = 0;
		int loopCounter = 0;
		while (i + j < loopLimit) {
			if (i < a.length && j < b.length) {
				if (a[i] < b[j]) {
					c[loopCounter] = a[i];
					i++;
					System.out.println(c[loopCounter]);
					loopCounter++;
				} else {
					c[loopCounter] = b[j];
					j++;
					System.out.println(c[loopCounter]);
					loopCounter++;
				}

			} else if (i < a.length) {
				c[loopCounter] = a[i];
				i++;
				System.out.println(c[loopCounter]);
				loopCounter++;

			} else {
				c[loopCounter] = b[j];
				j++;
				System.out.println(c[loopCounter]);
				loopCounter++;
			}
		}
		System.out.println(Arrays.toString(c));
	}

}
