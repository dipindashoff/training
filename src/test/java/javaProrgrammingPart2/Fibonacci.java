package javaProrgrammingPart2;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    public static void main(String[] args) {

        // 1 1 2 3 5 8...
        // Print first 15 numbers in the fibonacci series

        int firstNum = 1;
        int secondNum = 1;
        int result = 0;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);

        System.out.print("1 1 ");

        int i = 1;
        while (i <= 13) {

            result = firstNum + secondNum;
            firstNum = secondNum;
            secondNum = result;
            list.add(result);

//		System.out.print(result + " ");

            i++;
        }

        System.out.println();
        list.forEach(x -> System.out.print(x + " "));
    }

}
