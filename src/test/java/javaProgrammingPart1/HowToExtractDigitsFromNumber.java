package javaProgrammingPart1;

public class HowToExtractDigitsFromNumber {

	public static void main(String[] args) {

		int n = 153;
		int temp = n;
		int r = 0, sum = 0;
		int counter = 1;

		// extracting each digit by dividing the number by 10 one after another while
		// decreasing 'n'
		while (n > 0) {

			System.out.println(n+"/10");

			r = n % 10;
			n = n / 10;

			System.out.println("counter=" + counter);
			System.out.println("----------");
			System.out.println("n=" + n + " r=" + r);

			counter++;
			System.out.println();
		}

	}

}
