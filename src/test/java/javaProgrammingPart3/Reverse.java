package javaProgrammingPart3;

public class Reverse {

    public static void main(String[] args) {
//        String str = "testing";
//        reverseString(str);
//
//        int number = 123;
//        reverseNumber(number);

        int negativeNumber = 210; //123, -123,
        System.out.println("Reverse of Negative or Positive Number: " + reverseNegativeNumber(negativeNumber));

    }

    public static void reverseString(String str) {
        char[] charArray = str.toCharArray();
        for (int i = charArray.length - 1; i >= 0; i--) {
            System.out.print(charArray[i] + " ");
        }
    }

    public static void reverseNumber(int number) {
        int reminder;
        while (number > 0) {
            reminder = number % 10;
            number = number / 10;
            System.out.print(reminder + " ");
        }
    }

    public static int reverseNegativeNumber(int number) {
        int signMultiplier = 1;

        if (number < 0) {
            signMultiplier = -1;
            number = number * signMultiplier;
        }
        return signMultiplier * reverseNumberWithResult(number);
    }

    public static int reverseNumberWithResult(int number) {
        int currentDigit, result = 0;
        while (number > 0) {
            currentDigit = number % 10;
            result = result * 10 + currentDigit;
            number = number / 10;
        }
        return result;
    }
}
