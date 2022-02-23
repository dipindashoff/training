package javaProgrammingPart1;

public class ArmstrongNumber {

	/*
	NOTE: THIS ONLY WORKS IF A NUMBER IS A 3 DIGIT NUMBER
	 */
	
	/*
	 * Armstrong number is a number that is equal to the sum of cubes of its digits. 
	 * For example 0, 1, 153, 370, 371 and 407 are the Armstrong numbers. 
	 * Let's try to understand why 153 is an Armstrong number.
	 */

	public static void main(String... args) {

		int n = 153;
		int temp = n;
		int r = 0, sum = 0;
		int counter = 0;

		// extracting each digit by dividing the number by 10 one after another while
		// decreasing 'n'
		while (n > 0) {
			r = n % 10;
			n = n / 10;

			System.out.println("r=" + r + " n = " + n);

			sum = sum + r * r * r;
			counter++;
			System.out.println(counter);
		}

		if (temp == sum)
			System.out.println(temp + " is an Armstrong number");
		else
			System.out.println(temp + " is not an Armstrong number");

	}

//			counter=1
//			----------
//			r=3 n = 15
//
//			counter=2
//			----------
//			r=5 n = 1
//
//			counter=3
//			----------
//			r=1 n = 0

}
