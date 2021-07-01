package javaProgrammingPart1;

public class FibonacciSequence {

	public static void main(String[] args) {

		// 1 1 2 3 5 8 13 21

		int first = 1, second = 1, result = 0;
		System.out.print(first);
		for (int i = 1; i <= 10; i++) {

			result = first + second;
			first = second;
			second = result;

			System.out.print(" " + first + " ");
		}

	}

}
