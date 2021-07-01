package DesignPatterns.headfirst.learning.strategy.newway;

public class RedHeadDuck extends Duck {

    public RedHeadDuck() {
        flyableBehavior = new FlyHigh();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a Redhead Duck");
    }
}
