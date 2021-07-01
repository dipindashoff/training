package staticKeyword;

public class Child extends Parent{

//    public static void doStuff(){
//        System.out.println("Child");
//    }

    public void method1(){
        System.out.println("Child");
    }

    public static void main(String[] args) {
//        Parent parent = new Parent();
//        parent.doStuff();
//        Parent.doStuff();
//        Child child = new Child();
//        Child.doStuff();
        Child.doStuff();
//        child.doStuff();
//        Child.doStuff();

//        parent.method1(); // Parent
//        child.method1(); //
//
//        // after overriding
//        child.method1(); // child





    }
}
