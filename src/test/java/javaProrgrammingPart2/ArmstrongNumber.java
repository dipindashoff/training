package javaProrgrammingPart2;

import java.util.Scanner;

public class ArmstrongNumber {

    public static void main(String[] args) {

        /*
         * This java program checks if a number is Armstrong or not. Armstrong number is
         * a number which is equal to sum of digits raise to the power total number of
         * digits in the number. Some Armstrong numbers are: 0, 1, 4, 5, 9, 153, 371,
         * 407, 8208 etc.
         */
        // 153 = 1*1*1 + 5*5*5 + 3*3*3
        // 8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

        Scanner obj = new Scanner(System.in); // Create a Scanner object
        System.out.println("Enter number");
        int number = obj.nextInt();
        obj.close();
        isArmstrong(number);
    }

    public static void isArmstrong(int number) {

        int temp = 0, r = 0, sum = 0, count = 0;

        // Extract each digit from the number
        // Create a temp var to store the original number
        temp = number;

        count = getDigits(number);

        while (number > 0) {
            r = number % 10;
            number /= 10;

            sum += (int) Math.pow(r, count);
        }

        if (temp == sum)
            System.out.println(temp + " is an Armstrong number");
        else
            System.out.println(temp + " is NOT an Armstrong number");
    }

    public static int getDigits(int num) {
        int count = 0, r = 0;
        while (num > 0) {
            num = num / 10;
            count++;
        }
        return count;
    }
}
