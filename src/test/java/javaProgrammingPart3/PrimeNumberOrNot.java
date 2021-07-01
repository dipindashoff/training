package javaProgrammingPart3;

import java.util.Arrays;

public class PrimeNumberOrNot {

    public static void main(String[] args) {
        int number = 9;
//        System.out.println(number + " is Prime? " + isPrimeNormal(number));
//        System.out.println(number + " is Prime? " + isPrimeUptoSqRtOfN(number));
//        System.out.println(number + " is Prime? " + isPrimeDivisibleOnlyTwice(number));
        System.out.println("Print Prime Numbers from 1 to 100");
//        printPrimeNumbersInRange();
        findPrimeNumbersUsingErotosthenesSieveSimple();
//        findPrimeNumbersUsingErotosthenesSieve();
//        findPrimeNumbersUsingErotosthenesSieveOddNumbers();
    }

    /*
    Check if a number is prime or not
    Prime no. is divisible by 1 and by that number
    So if the number is divisible by any other number in-between ie from 2 to (number - 1), it is not a prime number
     */
    public static boolean isPrimeNormal(int number) {
        //Negative case
        // 0 and 1 are not prime
        if (number == 0 || number == 1 || number < 0)
            return false;

        // Prime no. is divisible by 1 and by that number
        // If any number is divisible by any other number in between ie 2 to (number - 1), it is not a prime number
        for (int i = 2; i < number; i++)
            if (number % i == 0)
                return false;
        return true;
    }

    // Prime no. is divisible by 1 and by that number
    // i.e if it's divisible only twice, then it's a Prime number
    public static boolean isPrimeDivisibleOnlyTwice(int number) {
        //Negative case
        // 0 and 1 are not prime
        if (number == 0 || number == 1 || number < 0)
            return false;

        // Prime no. is divisible by 1 and by that number
        int f_count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0)
                f_count++;
        }

        if (f_count == 2)
            return true;
        else
            return false;
    }

    /*
    OPTIMIZED SOLUTIONS
     */

    /*
    Shorten range from 2 to N
    to
    2 to sqrt of N
    If N is not-prime, then there'll be at least 2 factors of N that is <=sqrt of N and >= sqrt of N
     */
    public static boolean isPrimeUptoSqRtOfN(int number) {
        // Negative case
        // 0 and 1 are not prime
        if (number == 0 || number == 1 || number < 0)
            return false;

        // If N is divisible by any other number in-between ie 2 to square root of N, it is not a prime number
        for (int i = 2; i <= Math.sqrt(number); i++)
            if (number % i == 0)
                return false;
        return true;
    }

    /*
    Print all prime numbers from 1 to 100
     */
    public static void printPrimeNumbersInRange() {

        int N = 100;

        for (int i = 2; i <= N; i++) {
            if (isPrime(i))
                System.out.print(i + " ");
        }
    }

    public static boolean isPrime(int number) {
        for (int j = 2; j <= Math.sqrt(number); j++) {
            if (number % j == 0)
                return false;
        }
        return true;
    }

    /*
    Find prime numbers between 1 to 100 using Erotosthenes sieve
    Mark all numbers from 2 to N as prime (0 & 1 are not prime)
    Check every number from 2 to N for primality
    If a number is Prime, cross out all multiples of that number

    Optimization:
    ------------
    When crossing out, shorten range from 2 to N to i*i to N
    eg if i=7, start from 49 to N
    ie SKIP doing 7x2, 7x3, 7x4, 7x5, 7x6
    because 2x7, 3x7, 4x7, 5x7, 6x7 are already crossed out
    so start from 7x7, 7x8... N
    */
    public static void findPrimeNumbersUsingErotosthenesSieve() {

        // Upto
        int N = 100;

        // Mark all numbers from 1 to N as prime
        boolean[] isPrime = new boolean[N];
        Arrays.fill(isPrime, true);
        // 1 is not prime
        isPrime[0] = false;

        // Check every number >=2 for primality
        for (int i = 2; i <= N; i++) {
            // i is prime if it hasn't been "crossed off" yet
            // here i is index - 1
            if (isPrime[i - 1]) {
                System.out.print(i + " ");
                // Cross out all multiples of i i.e 2i, 2i+i, 4i,... N
                for (int j = i * i; j <= N; j += i)
                    isPrime[j - 1] = false;
            }
        }
    }

    /*
    Erotosthenes Sieve: Mark all even numbers as false and odd numbers as true
    */
    public static void findPrimeNumbersUsingErotosthenesSieveOddNumbers() {

        // From 0 to N
        int N = 100;

        // Mark all even numbers as false
        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime, false); //

        // Mark all odd numbers as true
        for (int o = 3; o <= N; o += 2)
            isPrime[o] = true;

        for (int i = 3; i <= N; i += 2) {
            // if prime number, cross out all multiples of it
            if (isPrime[i]) {
                // Cross out all multiples of i i.e 2i, 2i+i, 4i,... N
                for (int j = i * i; j <= N; j += i)
                    isPrime[j] = false;
            }
        }

        // Special cases:
        // 0 & 1 are not prime
        // 2 is prime
        isPrime[0] = false;
        isPrime[1] = false;
        isPrime[2] = true;

        // Print the prime numbers
        for(int i=1; i<=N; i++)
            if (isPrime[i])
                System.out.print(i + " ");

    }

    /*
    Print all prime numbers from 1 to 100

    1) Shorten range from 2 to N to 2 to N/2
    N cannot be divisible by numbers greater than N/2

    1.5) Shorten range from 2 to N/2 to 2 to sqrt of N
    ie if N is not-prime, then there'll be at least 2 factors of N that is <=sqrt of N and >= sqrt of N

    2) When crossing out shorten range from 2 to N to i*i to N
     */
    public static void findPrimeNumbersUsingErotosthenesSieveSimple() {

        int N = 100;
        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);

//        for (int i = 2; i <= N; i++) {
//        for (int i = 2; i <= N/2; i++) {
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (isPrime(i))
//                for(int j = 2*i; j<=N; j += i)
                for(int j = i*i; j<=N; j += i)
                    isPrime[j] = false;
        }

        // Special cases:
        // 0 & 1 are not prime
        // 2 is prime
        isPrime[0] = false;
        isPrime[1] = false;
//        isPrime[2] = true;

        for(int i=0; i<=N; i++)
            if (isPrime[i])
                System.out.print(i + " ");

    }
}
