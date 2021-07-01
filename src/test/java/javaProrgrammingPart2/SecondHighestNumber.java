package javaProrgrammingPart2;

import java.util.Arrays;
import java.util.List;

public class SecondHighestNumber {

	public static void main(String[] args) {

		// Print Second Highest Number in a List of numbers

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		int max = 0;
		int secondMax = 0;

		for (int i : list) {

			if (i > max) {
				secondMax = max;
				max = i;
			} else if(i > secondMax) {
				secondMax = i;				
			}
		}
		
		System.out.println("Highest Number is "+max);
		System.out.print("Second Highest Number is "+secondMax);

	}

}
