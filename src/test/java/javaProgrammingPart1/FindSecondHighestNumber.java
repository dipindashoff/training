package javaProgrammingPart1;

public class FindSecondHighestNumber {

	public static void main(String[] args) {

		int[] a = { 30, 1000, 8 };

		// Find Second Highest
		int max = a[0], secondMax = a[0];

		for (int i = 0; i < a.length; i++) {

			if (a[i] > max) {
				secondMax = max;
				max = a[i];
			} else if (a[i] > secondMax)
				secondMax = a[i];
		}

		System.out.println("max: " + max + " Second Max: " + secondMax);

	}

}
