package collections;

import java.util.HashMap;
import java.util.Map;

public class MapIteration {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<>();

		map.put("a", "apple");
		map.put("b", "ball");

		for (Map.Entry<String, String> entry : map.entrySet())
			System.out.println("[Key] : " + entry.getKey() + " [Value] : " + entry.getValue());

		map.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));

	}

}
