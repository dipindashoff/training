package javaProrgrammingPart2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PrintDuplicatesInString {

	public static void main(String[] args) {

		String str = "nincompoop";

		// Print all duplicates characters
		// Method 1 - faulty; repeats duplicates
//		usingOnlyForLoop(str); // n o p o
//		System.out.println();
//		// Method 2 - fixed the fault
//		usingOnlyForLoop2(str); // n o p
//		System.out.println();
//		// Method 3 - also prints the count
//		usingOnlyForLoop3(str); // n o p
//		System.out.println();
		// Print only the most duplicate character
		usingOnlyForLoop4(str);
//
//		// Print all duplicates characters
//		usingSet(str); // p n o
//		// Print all duplicates characters with counts
//		usingMap(str);

	}

	// Print all duplicates characters - faulty! it repeats the duplicates
	public static void usingOnlyForLoop(String str) {
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			for (int j = i + 1; j < charArray.length; j++) {
				if (charArray[i] == charArray[j]) {
					System.out.print(charArray[i] + " ");
					break;
				}
			}
		}
	}

	// Print all duplicates characters - fixed no more repeating the duplicates
	public static void usingOnlyForLoop2(String str) {
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			for (int j = i + 1; j < charArray.length; j++) {
				if (charArray[i] == charArray[j] && charArray[i] != ' ' && charArray[i] != '0') {
					System.out.print(charArray[i] + " ");
					// Set string[j] to 0 to avoid printing visited character
					charArray[j] = '0';
					break;
				}
			}
		}
	}

	// Print all duplicates characters along with their counts
	public static void usingOnlyForLoop3(String str) {
		char[] charArray = str.toCharArray();
		// Counts each character present in the string
		int count;
		for (int i = 0; i < charArray.length; i++) {
			count = 1;
			for (int j = i + 1; j < charArray.length; j++) {
				if (charArray[i] == charArray[j] && charArray[i] != ' ') {
					count++;
					// Set string[j] to 0 to avoid printing visited character
					charArray[j] = '0';
				}
			}
			// A character is considered as duplicate if count is greater than 1
			if (count > 1 && charArray[i] != '0')
				System.out.print(charArray[i] + " " + count + "\n");
		}
	}
	
	// Print the highest duplicate character in the string
	public static void usingOnlyForLoop4(String str) {
		char[] charArray = str.toCharArray();
		// Counts each character present in the string
		int count, max = 0;
		char res = '\0';
		for (int i = 0; i < charArray.length; i++) {
			count = 1;
			for (int j = i + 1; j < charArray.length; j++) {
				if (charArray[i] == charArray[j] && charArray[i] != ' ') {
					count++;
					// Set string[j] to 0 to avoid printing visited character
					charArray[j] = '0';
				}
			}
			
			if (count > max) {
				max = count;
				res = charArray[i];
			}				
		}
		
		System.out.println(res);
	}

	// Print all duplicates characters - using Set
	public static void usingSet(String str) {
		char[] charArray = str.toCharArray();
		Set<Character> unique = new HashSet<>();
		Set<Character> repeats = new HashSet<>();

		for (int i = 0; i < charArray.length; i++) {
			if (!unique.add(charArray[i]))
				repeats.add(charArray[i]);
		}
		repeats.forEach(x -> System.out.print(x + " "));
	}

	// Print all duplicates characters along with their counts using a hash map
	public static void usingMap(String str) {
		char[] charArray = str.toCharArray();
		Map<Character, Integer> map = new HashMap<>();

		for (char c : charArray) {
			if (map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else
				map.put(c, 1);
		}
		// Print
		map.forEach((k, v) -> System.out.println(k + " " + v));
	}

}
