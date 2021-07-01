package javaProgrammingPart3;

import org.bson.io.BsonOutput;
import org.testng.annotations.Test;

public class FindVowelInString {

    @Test
    // Create an array of vowel letters
    // TIP: Extract each char from th String and check if it's in the vowel array
    public void findVowelInStringOldWay() {
        String inputStr = "Apple";
//        String inputStr = "SDftyh";

        // Vowels
        char[] arrVowel = {'a', 'e', 'i', 'o', 'u'};

        for (int i = 0; i <= inputStr.length() - 1; i++) {
            char strCharacter = inputStr.toLowerCase().charAt(i);

            for (int j = 0; j < arrVowel.length; j++) {
                if (strCharacter == arrVowel[j])
                    System.out.print("Vowels in the String: " + strCharacter + " ");
            }
        }
    }

    @Test
    public void findConsonentInString() {
        String inputStr = "Apple";
//        String inputStr = "SDftyh";

        System.out.print("Consonents: ");
        inputStr = inputStr.toLowerCase();

        for (int i = 0; i <= inputStr.length() - 1; i++) {
            if (inputStr.charAt(i) == 'a' || inputStr.charAt(i) == 'e' || inputStr.charAt(i) == 'i' || inputStr.charAt(i) == 'o' || inputStr.charAt(i) == 'u') {
                continue;   //Skip if it's a vowel
            } else if (inputStr.charAt(i) >= 'a' && inputStr.charAt(i) <= 'z')
                System.out.print(inputStr.charAt(i));
        }
    }

    @Test
    public void findVowelUsingRegularExpression() {
        String inputStr = "Apple";
//        String inputStr = "SDftyh";

        System.out.println(inputStr.toLowerCase().matches(".*[aeiou].*"));
    }

}
