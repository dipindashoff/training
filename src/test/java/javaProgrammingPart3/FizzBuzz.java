package javaProgrammingPart3;

import org.testng.annotations.Test;

public class FizzBuzz {
    /*
    Write a program that prints the numbers from 1 to 100 and for multiples
    of ‘3’ print “Fizz” instead of the number and for the multiples of ‘5’ print “Buzz”.
    Print "FizzBuzz" for numbers that are divisible by both 3 and 5
     */

    @Test
    public void fizzBuzz() {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0)   // divisible by 15
                System.out.println("FizzBuzz");
            else if (i % 3 == 0)
                System.out.println("Fizz");
            else if (i % 5 == 0)
                System.out.println("Buzz");
            else
                System.out.println(i);
        }
    }
}
