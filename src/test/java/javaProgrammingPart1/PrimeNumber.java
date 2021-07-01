package javaProgrammingPart1;

public class PrimeNumber {

	public static void main(String[] args) {

//		isPrimeNumber(1458);
		printPrimeNumbers(1, 100);

	}

	/**
	 * Check if a number is Prime or not
	 * 
	 * @param num
	 */
	
	/*
	 * We need to divide an input number, say 17 from values 2 to 17 and check the remainder. 
	 * If remainder is 0 number is not prime.
	 * No number is divisible by more than half of itself. So we need to loop through just numberToCheck/2. 
	 * If input is 17, half is 8.5 and the loop will iterate through values 2 to 8
	 */
	static void isPrimeNumber(int num) {

		boolean flag = true;
		// From 2 to half of num, because no number is divisible by more than its half!
		for (int i = 2; i <= num / 2; i++) {

//			System.out.println("i="+i);
//			System.out.println(num+"%"+i+"="+num%i);

			if (num % i == 0) {
				flag = false;
				break;
			}
		}

		if (flag)
			System.out.println(num + " is a Prime number!");
		else
			System.out.println(num + " is not a Prime number");

	}

	/**
	 * Display the prime numbers between 1 and 100
	 */
	static void printPrimeNumbers(int start, int end) {

		for (int i = start; i <= end; i++) {

			int num = i;

			if (num == 0 || num == 1) {
				System.out.println("'0' or '1' is not a prime number");
			}

			boolean flag = false;
			for (int j = 2; j <= num / 2; j++) {

				if (num != 1) {
					if (num % j == 0) {
						flag = true;
						break;
					}
				}
			}
			if (!flag && num != 1)
				System.out.println(num + " is a Prime number!");

		}
	}
}
