package collections;

import java.util.HashSet;
import java.util.Set;

public class SetIteration {

	public static void main(String[] args) {
		
		
		Set<String> set = new HashSet<>();
		
		set.add("a");
		set.add("b");
		
		
		set.forEach(System.out::println);

	}

}
