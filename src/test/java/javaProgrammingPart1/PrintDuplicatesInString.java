package javaProgrammingPart1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PrintDuplicatesInString {

	public static void main(String[] args) {

		usingForLoops("Dipin");
		usingSet("narayanan");
		usingHashMap("Dipin");
	}

	/**
	 * Using 2 for loops - prints only the duplicate letters in the string (& not the count)
	 * 
	 * @param str
	 */

	static void usingForLoops(String str) {

		char[] inp = str.toCharArray();
		System.out.println("Duplicate Characters are:");
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (inp[i] == inp[j]) {
					System.out.println(inp[j]);
					break;
				}
			}
		}
	}
	
	/**
	 * Using 2 Sets - prints only the duplicate letters in the string (& not the count)
	 * @param str
	 */
	
	static void usingSet(String str) {
		Set<Character> uniqueChars = new HashSet<Character>();
		Set<Character> repeats = new HashSet<Character>();
		for (int i = 0; i < str.length() - 1; i++)
			if (!uniqueChars.add(str.charAt(i)))
				repeats.add(str.charAt(i));

		repeats.forEach(a -> System.out.print(a + " "));
	}

	/**
	 * Using hash map - print the chars & the times they repeat in the String
	 * --> more efficient
	 */

	static void usingHashMap(String str) {

		char[] chArray = str.toCharArray();

		Map<Character, Integer> map = new HashMap<>();

		for (char c : chArray)
			if (map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else
				map.put(c, 1);

		map.forEach((key, value) -> System.out.println(key + " : " + value));

	}
}
