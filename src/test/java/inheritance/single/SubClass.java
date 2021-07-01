package inheritance.single;

import net.bytebuddy.implementation.bind.annotation.Super;

public class SubClass extends SuperClass {

    public SubClass(){
//        super(5);
        System.out.println("Inside Sub class");
    }

    public static void main(String[] args) {
        SubClass subClass = new SubClass();
    }
}
