package generics;

import java.util.HashMap;

public class TestWithGenerics {

    public static void main(String[] args) {
        // with one param T
        genericWithOneParameter();
        // with two params T, V
        genericWithTwoParameter();
        // T is always a number (not String)
        genericExtendsNumber();
        // Using <?>
        genericWithQuestionMark();

        HashMap<Integer, String> map = new HashMap<>();
    }


    public static void genericWithOneParameter(){
        MyClassGeneric<Integer> myClassInteger = new MyClassGeneric<>(10);
        myClassInteger.print();

        MyClassGeneric<Double> myClassDouble = new MyClassGeneric<>(20.0);
        myClassDouble.print();
        // and so on...
    }

    public static void genericWithTwoParameter(){
        MyClassGenericTwo<Integer, Double> myClassIntegerDouble = new MyClassGenericTwo<>(10, 20.0);
        myClassIntegerDouble.getClassName();
    }

    public static void genericExtendsNumber(){
        // Type parameter 'java.lang.String' is not within its bound; should extend 'java.lang.Number'
//        NumericFns<String> numericFns = new NumericFns<>(10); // throws error
        NumericFns<Integer> numericFns = new NumericFns<>(10);
        System.out.println(numericFns.square());
    }

    public static void genericWithQuestionMark(){
        NumericFns<Integer> iOb = new NumericFns<>(10);
        NumericFns<Double> dOb = new NumericFns<>(-10.0);

        /*
        Error when it was 'absValue(NumericFns<T> ob)'
        Required type: NumericFns <Integer>
        Provided: NumericFns <Double>
         */
        System.out.println(iOb.absValue(dOb));
    }
}
