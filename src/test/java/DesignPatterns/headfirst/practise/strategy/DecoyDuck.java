package DesignPatterns.headfirst.practise.strategy;

public class DecoyDuck extends Duck {
    public DecoyDuck() {
        this.flyBehavior = new FlyNoWings();
        this.quackBehavior = new NoQuack();
    }

    @Override
    public void display() {
        System.out.println("This is a decoy duck");
    }

    /* does not quack */

}
