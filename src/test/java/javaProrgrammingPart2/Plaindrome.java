package javaProrgrammingPart2;

import java.util.ArrayList;
import java.util.List;

public class Plaindrome {

	public static void main(String[] args) {

		// Check if a string is a palindrome
//		String str = "abra";

//		if (isPalindromeString(str))
//			System.out.println("Word is a palindrome");
//		else
//			System.out.println("Not a palindrome!");

		if (isPalindromeNumber(5665))
			System.out.println("Palindrome!");
		else
			System.out.println("Not a palindrome");

	}

	public static boolean isPalindromeString(String str) {

		str = str.toLowerCase();

		int i = 0;
		int j = str.length() - 1;
		while (i < j) {

			if (str.charAt(i) != str.charAt(j))
				return false;

			i++;
			j--;

		}
		return true;
	}

	public static boolean isPalindromeNumber(int number) {

		List<Integer> numList = new ArrayList<>();

		while (number > 0) {
			numList.add(number % 10);
			number = number / 10;
		}

//		for (int n : numList)
//			System.out.print(n + " ");

		int i = 0, j = numList.size() - 1;
		while (i < j) {

			if (numList.get(i) != numList.get(j))
				return false;

			i++;
			j--;
		}
		return true;

	}

	// String or Number - Same logic! - using reverse
	public static void isPalindromeStringOrNumber(String str) {

		String reverse = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			reverse = reverse + str.charAt(i);
		}
		System.out.println("reverse is:" + reverse);

		if (str.equals(reverse))
			System.out.println("The input is palindrome");
		else
			System.out.println("The input is not a palindrome");
	}

}
