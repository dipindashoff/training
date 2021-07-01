package constructor;

import clojure.lang.IFn;

public class Test {

    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog(); //Inside Animal no-args constructor //Inside Dog no-args constructor
    }
}
