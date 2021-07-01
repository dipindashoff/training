package mergeArrays;

import java.util.Arrays;

public class MergeArrays3 {
	/*
	 * Solution!
	 */

	public static void main(String[] args) {

		int[] a = { 0, 1, 3, 5, 9, 10, 13, 14, 15, 17 };
		int[] b = { 1, 4, 7, 9, 11, 12, 13, 20, 21, 22, 25, 30 };

		int[] c = new int[a.length + b.length];

		// Compare a & b values
		int i = 0, j = 0, k = 0;

		while (j < a.length && k < b.length) {

//			System.out.println("i = " + i);

			System.out.println("i = " + i);
			System.out.println("j = " + j);
			System.out.println("k = " + k);

			if (a[j] < b[k]) {
				c[i] = a[j];
				System.out.println("c[" + i + "] = " + c[i]);
				System.out.println();
				j++;
				i++;
			} else if (b[k] < a[j]) {
				c[i] = b[k];
				System.out.println("c[" + i + "] = " + c[i]);
				System.out.println();
				k++;
				i++;
			} else if (a[j] == b[k]) {
				c[i] = a[j];
				i++;
				c[i] = b[k];
				System.out.println("c[" + i + "] = " + c[i]);
				System.out.println();
				i++;
				j++;
				k++;

			}
		}
		// If a array limit has reached, copy only from b array
		if (j == a.length && k < b.length) {
			while (k < b.length) {
				// Add items only from b
				c[i] = b[k];
				i++;
				k++;
			}
		} 
		// If b array limit has reached, copy only from a array
		else if (k == b.length && j < a.length) {
			while (j < a.length) {
				// Add items only from b
				c[i] = a[j];
				i++;
				j++;
			}
		}

		// Print c[]
		System.out.println(Arrays.toString(c));
	}

}
