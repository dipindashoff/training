package mergeArrays;

import java.util.Arrays;

public class MergeArrays2 {
	/*
	 * Works only for this data. If you add items in the array, it wont work.
	 */

	public static void main(String[] args) {

		int[] a = { 0, 1, 3, 5, 9 };
		int[] b = { 1, 4, 7, 9 };

		int[] c = new int[a.length + b.length];

		// Compare a & b values
		int i = 0, j = 0, k = 0;

		while (j < a.length && k < b.length) {

			System.out.println("i = " + i);

			if (a[j] < b[k]) {
				c[i] = a[j];
				System.out.println(c[i]);
				j++;
				i++;
			} else if (b[k] < a[j]) {
				c[i] = b[k];
				System.out.println(c[i]);
				k++;
				i++;
			} else if (a[j] == b[k]) {
				c[i] = a[j];
				i++;
				c[i] = b[k];
				System.out.println(c[i]);
				i++;
				j++;
				k++;

			}
			System.out.println("New i = " + i);
			System.out.println(c[i - 1]);
		}

		// Print c[]
		System.out.println(Arrays.toString(c));
	}

}
