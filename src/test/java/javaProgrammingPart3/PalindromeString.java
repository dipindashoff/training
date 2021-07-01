package javaProgrammingPart3;

public class PalindromeString {

    /*
    Palindrome is a word that reads the same backward as forward.
    Single Word Palindromes eg Madam, Civic, kayak, Level...
    Multi Word Palindromes eg Don't nod, My gym, Red rum, sir, is murder
     */

    public static void main(String[] args) {
//        String str = "racecar";
//        String str = "Civic";
//        String str = "Kayak";
//        String str = "Madam";
//        String str = "MadamM";
//        String str = "tattarrattat";
        String str = "Dont nod";
//        String str = "Red rum, sir, is murder";
        String modifiedStr = str.toLowerCase().replaceAll("\\W", "");

        if (isPalindrome(modifiedStr)) // OR
//        if (isPalindromeReverseString(modifiedStr))
            System.out.println(str + " is a Palindrome");
        else
            System.out.println(str + " is NOT a Palindrome");
    }

    static boolean isPalindrome(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0, j = charArray.length - 1; i < j; i++, j--) {
            if (charArray[i] != charArray[j])
                return false;
        }
        return true;
    }

    static boolean isPalindromeReverseString(String str) {
//        StringBuilder reverseStr = new StringBuilder(str);
//        reverseStr.reverse();
        // OR
        // Without using reverse method
        StringBuilder reverseStr = new StringBuilder();
        char[] charArray = str.toCharArray();
        for (int i = str.length() - 1; i >= 0; i--)
            reverseStr.append(charArray[i]);
        if (str.equals(reverseStr.toString()))
            return true;
        return false;
    }
}
