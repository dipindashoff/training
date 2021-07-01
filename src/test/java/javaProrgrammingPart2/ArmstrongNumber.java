package javaProrgrammingPart2;

import java.util.Scanner;

public class ArmstrongNumber {

	public static void main(String[] args) {

		/*
		 * This java program checks if a number is Armstrong or not. Armstrong number is
		 * a number which is equal to sum of digits raise to the power total number of
		 * digits in the number. Some Armstrong numbers are: 0, 1, 4, 5, 9, 153, 371,
		 * 407, 8208 etc.
		 */
		// 153 = 1*1*1 + 5*5*5 + 3*3*3

		Scanner obj = new Scanner(System.in); // Create a Scanner object
		System.out.println("Enter number");
		int number = obj.nextInt();
		obj.close();
		if (isArmstrong(number))
			System.out.println(number + " is an Armstrong number");
		else
			System.out.println(number + " is not an Armstrong number");

	}

	public static boolean isArmstrong(int number) {

		int temp = 0, r = 0, sum = 0;

		// Extract each digit from the number

		// Create a temp var to store the original number
		temp = number;

		while (number > 0) {
			// Extract
			r = number % 10;
			number = number / 10;

			// Calc sum of cubes
			sum = sum + r * r * r;
		}

		if (temp == sum) {
			return true;
		}
		return false;
	}

}
