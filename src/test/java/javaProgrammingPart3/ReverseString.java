package javaProgrammingPart3;

import org.testng.annotations.Test;

public class ReverseString {

    public static void main(String[] args) {
        String str = "Apple";
        System.out.print("'" + str + "' after reversal is '");
        reverseString(str);
        System.out.println("'");

        str = "Madam";
        str = "don't nod";
        System.out.println("'" + str + "' after reversal is '" + reverseStringRecursion(str) + "'");
    }


    // TIP: Print the String characters in reverse order
    public static void reverseString(String str) {
        // Reverse a String
        // Input: Apple
        // Output: elppA
        String inputStr = "Apple";
        if (inputStr != null) {
            for (int i = inputStr.length() - 1; i >= 0; i--)
                System.out.print(inputStr.charAt(i));
        } else
            throw new IllegalArgumentException("Invalid input");
    }


    public static String reverseStringRecursion(String str) {

        // Terminating condition
        if(str == null || str.length() <=1)
            return str;
        // Recursion
        return reverseStringRecursion(str.substring(1)) + str.charAt(0);
    }


}
