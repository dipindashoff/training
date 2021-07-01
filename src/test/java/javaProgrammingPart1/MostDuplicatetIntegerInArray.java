package javaProgrammingPart1;

import java.util.Arrays;

public class MostDuplicatetIntegerInArray {

	public static void main(String[] args) {

		Integer[] arr = { 1, 1, 2, 3, 3, 3, 3, 4, 4, 5,5,5,5,5,5 };
		int counter = 1, maxCount = 0;
		int res = 0;

		// Sort the array
		Arrays.sort(arr);

		for (int i = 0; i < arr.length - 1; i++) {

			if (arr[i] == arr[i + 1])
				counter++;

	 		// Set maxCount
			else {
				if (counter > maxCount) {
					maxCount = counter;
					res = arr[i];
				}
				// Reset counter to 1
				counter = 1;
			}
		}

		// If last element is most frequent
		if (counter > maxCount) {
			maxCount = counter;
			res = arr[arr.length - 1];
		}
		// Print the integer with most duplicates
		System.out.println(res);
	}

}
