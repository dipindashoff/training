package javaProrgrammingPart2;

public class PrimeNumbers {

	public static void main(String[] args) {

//		if (isPrimeNumber(143))
		if (isPrimeNumber2(143))
			System.out.println("Prime Number!");
		else
			System.out.println("Not a Prime");

		printPrimeNumbers();
	}

	/*
	 * We need to divide an input number, say 17 from values 2 to 17 and check the
	 * remainder. If remainder is 0 number is not prime. No number is divisible by
	 * more than half of itself. So we need to loop through just numberToCheck/2. If
	 * input is 17, half is 8.5 and the loop will iterate through values 2 to 8
	 */

	// Check if a number is Prime
	public static boolean isPrimeNumber(int number) {

		for (int i = 2; i <= number / 2; i++) { // i<=number/2 -- don't forget the equal to; or it'll print 4 as Prime
			if (number % i == 0)
				return false;
		}
		return true;
	}

	// Print all Prime numbers in a range
	public static void printPrimeNumbers() {

		for (int i = 2; i <= 144; i++) {

			if (isPrimeNumber(i))
				System.out.print(i + " ");
		}
	}

	/*
	 * Another logic: A Prime number is divisible by itself & 1 only
	 */
	// Check if a number is Prime
	public static boolean isPrimeNumber2(int number) {

		int counter = 0;
		for (int i = number; i >= 1; i--) {
			if (number % i == 0)
				counter++;
		}
		// Counter equals 2 only when the number is divisible by itself & 1
		if (counter == 2)
			return true;

		return false;

	}

}
