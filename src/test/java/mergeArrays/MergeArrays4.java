package mergeArrays;

import java.util.Arrays;

public class MergeArrays4 {
	/*
	 * My Solution using only 1 loop
	 */

	public static void main(String[] args) {

		int[] a = { 0, 1, 3, 5, 9, 10, 13, 14, 15, 17 };
		int[] b = { 1, 4, 7, 9, 11, 12, 13, 20, 21, 22, 25, 30 };

		int[] c = new int[a.length + b.length];

		// Compare a & b values
		int i = 0, j = 0, k = 0;

		while (i < c.length) {

			if (j < a.length && k < b.length) {
				if (a[j] < b[k]) {
					c[i] = a[j];
					j++;
					i++;
				} else if (b[k] < a[j]) {
					c[i] = b[k];
					k++;
					i++;
				} else if (a[j] == b[k]) {
					c[i] = a[j];
					i++;
					c[i] = b[k];
					i++;
					j++;
					k++;
				}
			}
			// If a array limit has reached, copy only from b array
			else if (k < b.length) {

				c[i] = b[k];
				i++;
				k++;
			}
			// If b array limit has reached, copy only from a array
			else if (j < a.length) {

				c[i] = a[j];
				i++;
				j++;
			}
		}
		// Print c[]
		System.out.println(Arrays.toString(c));
	}

}
