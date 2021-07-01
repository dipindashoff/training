package javaProrgrammingPart2;

import java.util.HashMap;
import java.util.Map;

public class WordCountInString {

	public static void main(String[] args) {

		getWordCountInSentence("This this is is done by Saket Saket");
	}

	public static void getWordCountInSentence(String str) {

		String[] arr = str.split(" ");

		Map<String, Integer> map = new HashMap<>();

		for (String word : arr) {
			if (map.containsKey(word))
				map.put(word, map.get(word) + 1);
			else
				map.put(word, 1);
		}
		
		map.forEach((k, v)-> System.out.println(k + " " + v));
	}

}
