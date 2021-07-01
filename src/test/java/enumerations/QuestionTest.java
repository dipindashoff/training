package enumerations;

enum QuestionType {
    CATEGORICAL(1), OLD_NUMERIC(2), NEW_NUMERIC(3);

    int type;

    QuestionType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}

class QuestionAPI {
    QuestionType questionType;
}

public class QuestionTest {

    public static void main(String[] args) {
        QuestionAPI questionAPI = new QuestionAPI();
        questionAPI.questionType = QuestionType.CATEGORICAL;
        System.out.println(questionAPI.questionType); // CATEGORICAL
        System.out.println(questionAPI.questionType.getType()); //1

        // Get questionType from data sheet
        //
        constructBody(questionAPI.questionType);

    }

    public static void constructBody(QuestionType type) {
        // Get type
        // Pass it to switch case

        switch (type) {
            case CATEGORICAL:
                System.out.println("Construct body for CATEGORICAL question");
                break;
            case OLD_NUMERIC:
                System.out.println("Construct body for OLD_NUMERIC question");
                break;
            case NEW_NUMERIC:
                System.out.println("Construct body for NEW_NUMERIC question");
                break;
            // no need for a default case
        }
    }

}
