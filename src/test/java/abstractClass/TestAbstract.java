package abstractClass;

public class TestAbstract extends AbstractClass {

    TestAbstract() {
        System.out.println("TestAbstract Constructor");
    }

    public static void main(String[] args) {

        AbstractClass absObj = new TestAbstract();
        absObj.doSomething();

    }

    // Implementation of abstract method
    @Override
    void doSomething() {

    }

}
