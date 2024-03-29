package enumerations;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

enum QtnType {
    CATEGORICAL(1), OLD_NUMERIC(2), NEW_NUMERIC(3);

    private int code;

    private QtnType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

public class EnumRevisitQuestionTypes {

    /*
    If questionType = 1, then ...
    If questionType = 2, then ...
    If questionType = 3, then ...
     */

    public static void main(String[] args) throws InvalidQtnTypeException {
        // Get value of QtnType
        System.out.println(QtnType.CATEGORICAL.getCode());

        // Enum Map - enum constant should be the key always
        EnumMap<QtnType, Integer> enumMap = new EnumMap<QtnType, Integer>(QtnType.class);
        enumMap.put(QtnType.CATEGORICAL, 1);
        enumMap.put(QtnType.OLD_NUMERIC, 2);
        enumMap.put(QtnType.NEW_NUMERIC, 3);

        // String to enum constant
        QtnType qtnType = QtnType.valueOf("CATEGORICAL");
        System.out.println("qtnType = " + qtnType);

        int intType;
        intType = 2;

        // Map int to enum constants
//        qtnType = intToEnumQuestionTypeUsingIfElse(intType);
//        qtnType = intToEnumQuestionTypeUsingHashMap(intType);
        // Below is recommended
        qtnType = intToEnumQuestionTypeUsingLoop(intType);

        // Perform operations
        if (qtnType != null) {
            switch (qtnType) {
                case CATEGORICAL:
                    System.out.println("CATEGORICAL");
                    break;
                case OLD_NUMERIC:
                    System.out.println("OLD_NUMERIC");
                    break;
                case NEW_NUMERIC:
                    System.out.println("NEW_NUMERIC");
            }
        } else
            throw new IllegalArgumentException("Invalid question type");
    }

    /*
    METHOD 1: Map int to enum constants
     */
    public static QtnType intToEnumQuestionTypeUsingIfElse(int intType) {

        if (intType == QtnType.CATEGORICAL.getCode())
            return QtnType.CATEGORICAL;
        else if (intType == QtnType.OLD_NUMERIC.getCode())
            return QtnType.OLD_NUMERIC;
        else if (intType == QtnType.NEW_NUMERIC.getCode())
            return QtnType.NEW_NUMERIC;
        return null;
    }

    /*
    METHOD 2: Map int to enum constants using HashMap
     */
    public static QtnType intToEnumQuestionTypeUsingHashMap(int intType) {

        Map<Integer, QtnType> enumMap = new HashMap<>();
        enumMap.put(1, QtnType.CATEGORICAL);
        enumMap.put(2, QtnType.OLD_NUMERIC);
        enumMap.put(3, QtnType.NEW_NUMERIC);

        return enumMap.get(intType);
    }

    /*
    RECOMMENDED
    METHOD 3: Map int to enum constants using for loop & values method
    Convert enum constant to String or Integer and compare & return
     */
    public static QtnType intToEnumQuestionTypeUsingLoop(int intType) throws InvalidQtnTypeException {

        for (QtnType qtnType : QtnType.values()) {
//            if (Integer.parseInt(qtnType.toString()) == (intType))
            if (qtnType.getCode() == intType)
                return qtnType;
        }

        throw new InvalidQtnTypeException("The selected question type, " + intType + " is not an applicable");
    }

    static class InvalidQtnTypeException extends Exception {
        public InvalidQtnTypeException(String str) {
            super(str);
        }
    }
}