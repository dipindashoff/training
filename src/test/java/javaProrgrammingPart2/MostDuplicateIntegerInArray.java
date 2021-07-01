package javaProrgrammingPart2;

import java.util.Arrays;

public class MostDuplicateIntegerInArray {

	public static void main(String[] args) {

		Integer[] arr = { 1, 5, 3, 3, 5, 1, 5, 5, 3, 4, 5, 4, 4, 2 };

		int counter = 1, max = 0, res = 0;

		// First Sort the array
		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {

			for (int j = i + 1; j < arr.length; j++) {

				if (arr[i] == arr[j])
					counter++;
				else if (counter > max) {
					max = counter;
					res = arr[i];
					counter = 1;
				}
			}
		}
		// If last element is most duplicate
		if (counter > max) {
			max = counter;
			res = arr[arr.length - 1];
		}
		System.out.println(res);
	}

}
