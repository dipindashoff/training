package DesignPatterns.headfirst.learning.strategy.oldway;

public class MallardDuck extends Duck implements Flyable, Quackable {

    @Override
    public void display() {
        System.out.println("This is a Mallard Duck");
    }

    @Override
    public void fly() {
        System.out.println("MallardDuck Flies");
    }

    @Override
    public void quack() {
        System.out.println("MallardDuck Quacks");
    }
}
