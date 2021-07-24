package generics;

public class TestWithoutGenerics {

    public static void main(String[] args) {
        MyClassInteger myClassInteger = new MyClassInteger(10);
        myClassInteger.print();

        MyClassDouble myClassDouble = new MyClassDouble(20.0);
        myClassDouble.print();
        // and so on...
    }

}
