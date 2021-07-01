package javaProgrammingPart1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringReverse {

	public static void main(String[] args) {

//		reverseString("Madam");
//		System.out.println();
//
//		System.out.println(reverseSentence("A Santa Lived As a Devil At NASA."));
//
//		System.out.println(wordReverse("I am Dipin"));
//		

//		printReverse("I am Dipin.".toCharArray());
//		printReverseUsingb("I love Deesha. I am Dipin.");
//		System.out.println();
		System.out.println(reverseStringManeesh("I am Maneesh. I am a Java Developer."));

	}

	public static void reverseString(String str) {
		for (int i = (str.length() - 1); i >= 0; i--)
			System.out.print(str.charAt(i));
	}

	public static String reverseSentence(String str) {

		List<String> list = new ArrayList<>();

		for (String item : str.split(" "))
			list.add(item);

		Collections.reverse(list);

		// to take care of the '.' issue
		if (list.get(0).contains(".")) {
			list.set(0, list.get(0).replace(".", ""));
			return "." + String.join(" ", list);
		} else
			return String.join(" ", list);

	}

	/**
	 * From Internet
	 */
	static String wordReverse(String str) {
		int i = str.length() - 1;
		int start, end = i + 1;
		String result = "";

		while (i >= 0) {
			if (str.charAt(i) == ' ') {
				start = i + 1;

				while (start != end)
					result += str.charAt(start++);

				result += ' ';

				end = i;
			}
			i--;
			System.out.println("i:" + i);
		}

		start = 0;
		System.out.println("end:" + end);
		while (start != end)
			result += str.charAt(start++);

		return result;
	}

	/**
	 * Method 2
	 */
	static void printReverse(char str[]) {
		int length = str.length;

		// Traverse string from end
		int i;
		for (i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {

				// putting the NULL character at the
				// position of space characters for
				// next iteration.
				str[i] = '\0';

				// Start from next charatcer
//	            System.out.println(String.format("%s", ""));
				System.out.print(String.format("%s", (str[i + 1])));
			}
		}
		// TODO -- INCOMPLETE
		// printing the last word
//		for (i = length; i > str.length; i--)
//			System.out.print(str[i]);
//	    for(char c: str)
//	    	System.out.print(c);
//	    System.out.print("%s " +str); 
	}
	
	/***
	 * Does not work :-(
	 */

	/**
	 * Try again using \\b
	 */
	/**
	 * \b is a zero with assertion. That means it does not match a character, it
	 * matches a position with one thing on the left side and another thing on the
	 * right side.
	 * 
	 * The word boundary \b matches on a change from a \w (a word character) to a \W
	 * a non word character, or from \W to \w
	 * 
	 * Which characters are included in \w depends on your language. At least there
	 * are all ASCII letters, all ASCII numbers and the underscore. If your regex
	 * engine supports unicode, it could be that there are all letters and numbers
	 * in \w that have the unicode property letter or number.
	 * 
	 * \W are all characters, that are NOT in \w.
	 * 
	 * @param str
	 */
	static void printReverseUsingb(String str) {

		String[] array = str.split("\\b");

		for (int i = array.length - 1; i >= 0; i--)
			System.out.print(array[i]);
	}
	
	/**
	 * WORKS!!!!!!!!
	 */
	
	static String reverseStringManeesh(String str) {
		
		String result = "";
		
		// First split the string into sentences
		String[] sentences = str.split("\\.");
		
		for(String s: sentences) {
			String[] array = s.split(" ");
			List<String> list = Arrays.asList(array);
			Collections.reverse(list);
			result = "."+String.join(" ", list) + " "+ result;					
		}
		return result;
	}

}
