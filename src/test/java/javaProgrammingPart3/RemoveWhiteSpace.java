package javaProgrammingPart3;

import java.util.Arrays;
import java.util.List;

public class RemoveWhiteSpace {

    /*
    Remove extra white spaces between words.
    Only one white space is allowed between words.
    If more than one, remove it.
    If given string has leading or trailing white spaces, remove them as well.
    Do not use trim method.
     */

    public static void main(String[] args) {
//        System.out.println(removeWhiteSpacesBruteForce("     Humpty  Dumpty    sat  ")); //Humpty Dumpty sat [correct]
//        removeAllWhitespace("      Humpty  Dumpty    sat  "); //HumptyDumptysat [incorrect: no space between words]
        System.out.println(removeExtraWhitespaceUsingRegularExpressionWithTrim("     Humpty  Dumpty    sat  ")); // Humpty Dumpty sat [a space in the beginning]
        System.out.println(removeExtraWhitespaceUsingRegularExpressionWithoutTrim("     Humpty  Dumpty    sat  ")); //Humpty Dumpty sat [correct]
    }

    public static String removeWhiteSpacesBruteForce(String sentence) {
        String trimmedSentence = null;
        String[] words = sentence.split("\\s");
        System.out.println(Arrays.toString(words));
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(" ") || words[i].equals(""))
                continue;
            if (i != words.length - 1) //if NOT the last word append a space
                strBuilder.append(words[i] + " ");
        }
        trimmedSentence = strBuilder.toString();
        return trimmedSentence;
    }

    public static void removeAllWhitespace(String str) {

        char[] c = str.toCharArray();
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < str.length() - 1; i++) {
            // DO not add if more than 1 space
            if ((c[i] == ' ' && c[i++] != ' ') || (c[i] != ' '))
                strBuilder.append(c[i]);
        }
        System.out.print(strBuilder);
    }

    public static String removeExtraWhitespaceUsingRegularExpressionWithTrim(String str) {
        return str.trim().replaceAll("\\s{2,}+", " ");// Humpty Dumpty sat [adds a space in the beginning]
    }

    public static String removeExtraWhitespaceUsingRegularExpressionWithoutTrim(String str) {
//        return str.replaceAll("^ +| +$|( )+", "$1"); //Humpty Dumpty sat [Why does it not add a space at the start?]
        return str.replaceAll("^ +|( )+| +$", "$1"); //Humpty Dumpty sat [adds a space at the end]
    }

}
