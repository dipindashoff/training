package javaProrgrammingPart2;

import java.util.Scanner;

public class SwapNumbers {

	public static void main(String[] args) {

		Scanner x = new Scanner(System.in);
		System.out.println("Enter a number...");
		int a = x.nextInt();
		Scanner y = new Scanner(System.in);
		System.out.println("Enter another number...");
		int b = y.nextInt();

//		swapNumbersUsingTempVar(a, b);
		swapNumbersWithoutUsingTempVar(a, b);

	}

	public static void swapNumbersUsingTempVar(int a, int b) {

		a = 1;
		b = 2;

		System.out.println("Before swapping:");
		System.out.println("a: " + a + " b: " + b);

		int temp = 0;

		temp = a;
		a = b;
		b = temp;

		System.out.println("After swapping:");
		System.out.println("a: " + a + " b: " + b);
	}

	public static void swapNumbersWithoutUsingTempVar(int a, int b) {

		a = 1;
		b = 2;

		System.out.println("Before swapping:");
		System.out.println("a: " + a + " b: " + b);

		a = a + b;
		b = a - b;
		a = a - b;

		System.out.println("After swapping:");
		System.out.println("a: " + a + " b: " + b);
	}

}
