package mergeArrays;

import java.util.Arrays;

public class MergeArrays {
	
	/*
	 * Merge a & b arrays into c array.
	 * a & b arrays are sorted
	 * c array should be sorted before it's populated NOT AFTER unlike the program below
	 */

	public static void main(String[] args) {

		int[] a = { 0, 1, 3, 5, 9 };
		int[] b = { 1, 4, 7, 9 };

		int[] c = new int[a.length + b.length];

		for (int i = 0; i < a.length; i++) {
			c[i] = a[i];
		}

		int y = 0;
		for (int i = a.length; i < c.length && y < b.length; i++) {
			c[i] = b[y];
			y++;
		}
		System.out.println("Before Sorting...");
		System.out.println(Arrays.toString(c));

		// Sort the array
		int temp = 0;
		for (int i = 0; i < c.length; i++) {

			for (int j = i + 1; j < c.length; j++) {

				if (c[i] > c[j]) {
					temp = c[i];
					c[i] = c[j];
					c[j] = temp;
				}
			}
		}
		System.out.println("After Sorting...");
		System.out.println(Arrays.toString(c));
	}

}
