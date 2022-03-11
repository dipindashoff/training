package javaProgrammingPart3;

import java.util.*;

public class Revision {

    public static void main(String[] args) {
//        flattenArray();
//        moveZeroes();
//        reverseNumberWithResult();
//        rotationOfNumbers();
        printStarPyramid();
    }

    public static void flattenArray() {
        int[][] a = {{1, 2}, {3, 4, 5}, {6}};
        // Output: {1,2,3,4,5,6}

        // Get total size of new array
        int sum = 0;
        for (int[] i : a) {
            sum += i.length;
        }

        int result[] = new int[sum];
        int k = 0;

        for (int[] i : a) {
            for (int j : i) {
                result[k++] = j;
            }
        }

        for (int i : result)
            System.out.print(i + " ");
    }

    public static void moveZeroes() {
        int[] input = {0, 1, 0, 2, 3, 0, 9, 7};
        // Output = {1, 2, 3, 9, 7, 0, 0, 0}
        int count = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i] != 0) {
                input[count++] = input[i];
            }
        }
        while (count < input.length) {
            input[count] = 0;
            count++;
        }

        for (int i : input)
            System.out.print(i + " ");
    }

    public static void reverseNumberWithResult() {
        int num = -123;
        // Output = -321

        int digit, signMultiplier = 1;
        int result = 0;

        if (num < 0) {
            signMultiplier = -1;
            num = signMultiplier * num;
        }

        while (num > 0) {
            digit = num % 10;
            result = result * 10 + digit;
            num = num / 10;
        }

        System.out.println(signMultiplier * result);
    }

    public static void rotationOfNumbers() {
        int input[] = {4, 5, 1, 3};
        int min = input[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            map.put(input[i], i);
        }

        for (int i = 0; i < input.length; i++) {
            if (input[i] < min)
                min = input[i];
        }
        System.out.println(map.get(min));
    }

    public static void printStarPyramid() {
        int n = 4;

        // Right Side
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Left Side
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                if (j >= n - i)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }

        // Symmetrical
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n * 2 - 1; j++) {
                if (j >= n - i && j <= n + i)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }

        // Reverse L
        for (int i = 0; i < n; i++) {
            for (int j = n; j > 0; j--) {
                if (j <= n - i)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }

        // Reverse R
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }


    }
}
