package javaProgrammingPart3;

public class StringContainsIllegalCharacter {
    /*
    Check that string contains a character from array
     */
    private static final Character[] ILLEGAL_CHARACTERS = { '/', '\n', '\r', '\t', '\0', '\f', '`', '?', '*', '\\', '<', '>', '|', '\"', ':' };

    public static void main(String[] args) {

//        String string1 = "abc";
        String string1 = "abc\n";

        if(isContainsIllegalChars(string1))
            System.out.println("String contains illegal characters");
        else
            System.out.println("String is devoid of illegal characters");
    }

    public static boolean isContainsIllegalChars(String str){
        char[] charArray = str.toCharArray();
        for(char c: charArray){
//            System.out.println("character in string: " + c);
            for(char cArray: ILLEGAL_CHARACTERS){
//            System.out.println("character in ILLEGAL_CHARACTERS: " + cArray);
                if(c == cArray)
                    return true;
            }
        }
        return false;
    }
}
