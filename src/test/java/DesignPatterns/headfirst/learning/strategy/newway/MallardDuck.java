package DesignPatterns.headfirst.learning.strategy.newway;

public class MallardDuck extends Duck {

    public MallardDuck() {
        flyableBehavior = new FlyHigh();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a Mallard Duck");
    }

}
