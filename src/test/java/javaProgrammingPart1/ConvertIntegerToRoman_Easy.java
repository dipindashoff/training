package javaProgrammingPart1;

import java.util.Scanner;

public class ConvertIntegerToRoman_Easy {

	// Parallel arrays of numerals in descending order and their values. We
	// include any pairs of numerals where a smaller numeral is subtracted from
	// a larger numeral
	private static final String[] numerals = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V",
			"IV", "I" };
	private static final int[] values = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

	public static String integerToRoman(int value) {
		// We are only considering this range for standard roman numerals
		if (value > 3999 || value < 1)
			throw new IllegalArgumentException();

		StringBuilder numeral = new StringBuilder();
		int i = 0;
		// Greedily append the largest numeral possible until the value is 0
		while (value > 0) {
			
			if (value - values[i] >= 0) {
				numeral.append(numerals[i]);
				value -= values[i];
			} else
				i++;
		}
		return numeral.toString();
	}
	
	public static void main(String... args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a number...");
		int number = in.nextInt();
		System.out.println(integerToRoman(number));
		in.close();
	}
}
