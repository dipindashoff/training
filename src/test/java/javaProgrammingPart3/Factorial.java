package javaProgrammingPart3;


public class Factorial {

    public static void main(String[] args) {

        /*
        The maximum value a int can hold in java is 2,147,483,647 while
        13! = 6,227,020,800.

        So you see an int cannot hold 13! or higher. Its only big enough to hold 12! or less.
        So make the result return a 'long' instead of 'int'.
        'long' type can hold up to Factorial of 20
         */

        int number = 13;
        System.out.println(Integer.MAX_VALUE);
        System.out.println("Factorial of " + number + " is " + getFactorial(number));
        System.out.println("Factorial of " + number + " is " + getFactorial2(number));
        System.out.println("Factorial of " + number + " is " + getFactorialRecursive(number));
    }

    public static long getFactorial(int number) {
        // n! = (n-0) * (n-1) * (n-2)....(n-(n-1))
        // 0! = 1
        if (number == 0)
            return 1;
        long result = 1;
        for (int i = 0; i <= number - 1; i++)
            result = result * (number-i);
        return result;
    }

    public static long getFactorial2(int number) {
        // 5! = 5 * 4 * 3 * 2 * 1
        // i.e 5! = 1 * 2 * 3 * 4 * 5
        // 0! = 1
        if (number == 0 || number == 1)
            return 1;
        long result = 1;
        for (int i = 1; i <= number; i++)
            result *= i;
        return result;
    }

    public static long getFactorialRecursive(int number) {
        // n! = n * (n-1) * (n-2).... 1
        // ie 5! = 5 * 4!
        // 0! = 1! = 1
        if (number == 0 || number == 1)
            return 1;
        return number * getFactorialRecursive(number - 1);
    }
}
