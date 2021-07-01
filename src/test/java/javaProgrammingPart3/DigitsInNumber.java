package javaProgrammingPart3;

public class DigitsInNumber {

    public static void main(String[] args) {
        int number = 514;
//        System.out.println("No. of digits in '" + number + "' is '" + getDigits(number) + "'");
        System.out.println("No. of digits in '" + number + "' is '" + getDigitsRecursive(number) + "'");
    }

    public static int getDigits(int number) {

        int reminder;
        int count = 0;

        while (number != 0) {
            reminder = number % 10;
//            System.out.println("reminder = " + reminder);
            count++;
        }
        return count;
    }

    public static int getDigitsRecursive(int number) {

        // number/10 until number is 0
        // eg 514/10, 51/10, 5/10 stop

        if (number == 0)
            return 0;
        return 1 + getDigitsRecursive(number / 10);
    }

}


