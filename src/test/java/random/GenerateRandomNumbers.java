package random;

import java.util.Random;

public class GenerateRandomNumbers {

    public static void main(String[] args) {
        generateRandomUsingNextInt();
        generateRandomUsingMathRandom();
        generateRandomUsingJava8RandomInts();
    }

    /*
    Generate using nextInt()
     */
    public static void generateRandomUsingNextInt(){
        int min = 70;
        int max = 60;

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        System.out.println("Generate using nextInt()");
        System.out.println("range 0 to 9: " + (new Random().nextInt(10))); // range 0 to 9
        System.out.println("range 1 to 10: " + (new Random().nextInt(10) + 1)); // range 1 to 10
        System.out.println("range min to max: " + (new Random().nextInt((max-min) + 1) + min)); // range min to max
    }

    /*
    Generate using Math.random()
     */
    public static void generateRandomUsingMathRandom(){
        int min = 50;
        int max = 60;

        System.out.println("Generate using Math.random()");
        System.out.println("Generate a random number: " + (Math.random())); // range 0.0 to 1.0
        System.out.println("Generate a random int number in a range: " + ((int)(Math.random() * ((max-min)+1)) + min)); // range min to max
    }
    /*
    Generate using Java 8 Random.ints
     */
    public static void generateRandomUsingJava8RandomInts(){
        int min = 50;
        int max = 60;

        System.out.println("Generate using Java 8 Random.ints");
        System.out.println("Generate a random number in a range: " + (new Random().ints(min, (max+1))).findFirst().getAsInt()); // range min to max
        System.out.println("Generate 10 random numbers in a range: ");
        (new Random().ints(10, 1, 10)).forEach(System.out::println);
    }

}
