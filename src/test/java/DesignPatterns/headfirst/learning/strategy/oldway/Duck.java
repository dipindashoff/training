package DesignPatterns.headfirst.learning.strategy.oldway;

public abstract class Duck {

    public void swim() {
        System.out.println("Swims");
    }

    public abstract void display();

    /* Not all ducks fly */
//    public void fly(){
//        System.out.println("Flies");
//    }

    /* Not all ducks quack */
//    public void quack() {
//        System.out.println("Quacks");
//    }


}
